package net.chimaek.day0717_restapi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardPostService {

    List<BoardPost> boardPosts = new ArrayList<>();
    private Long nextPostId = 1L;
    private Long nextCommentId = 1L;

    public BoardPostDto createBoardPost(BoardPostDto boardPostDto) {
        BoardPost boardPost = convertToBoardPostEntity(boardPostDto);
        boardPost.setId(nextPostId++);
        boardPost.setCreatedAt(LocalDateTime.now());
        boardPosts.add(boardPost);
        return convertToBoardPostDto(boardPost);
    }

    private static BoardPost convertToBoardPostEntity(BoardPostDto boardPostDto) {
        BoardPost boardPost = new BoardPost();
        boardPost.setTitle(boardPostDto.getTitle());
        boardPost.setContent(boardPostDto.getContent());
        boardPost.setAuthor(boardPostDto.getAuthor());
        if (boardPostDto.getComments() != null) {
            boardPostDto.getComments().forEach(commentDto -> {
                Comment comment = convertToCommentEntity(commentDto);
                comment.setBoardPost(boardPost);
                boardPost.addComment(comment);

            });
        }
        return boardPost;
    }

    private static Comment convertToCommentEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setContent(commentDto.getContent());
        comment.setAuthor(commentDto.getAuthor());
        return comment;
    }

    private BoardPostDto convertToBoardPostDto(BoardPost boardPost) {
        BoardPostDto boardPostDto = new BoardPostDto();
        boardPostDto.setId(boardPost.getId());
        boardPostDto.setTitle(boardPost.getTitle());
        boardPostDto.setContent(boardPost.getContent());
        boardPostDto.setAuthor(boardPost.getAuthor());
        boardPostDto.setCreatedAt(boardPost.getCreatedAt());
        boardPostDto.setUpdatedAt(boardPost.getUpdatedAt());

        if (boardPost.getComments() != null) {
            boardPostDto.setComments(
                boardPost.getComments().stream().map(BoardPostService::convertToCommentDto)
                    .collect(Collectors.toList())
            );
        }
        return boardPostDto;
    }

    private static CommentDto convertToCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setAuthor(comment.getAuthor());
        commentDto.setCreatedAt(comment.getCreatedAt());
        return commentDto;
    }

    public List<BoardPostDto> getAllBoardPosts() {
        return boardPosts.stream()
            .map(this::convertToBoardPostDto)
            .collect(Collectors.toList());
    }

    public BoardPostDto getBoardPostDtoById(Long id) {
        log.info("뀨뀨뀨뀨뀨뀨 로큐큐뀨");
        return boardPosts.stream()
            .filter(post -> post.getId().equals(id))
            .map(this::convertToBoardPostDto)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("id에 해당하는 글을 찾을 수 없습니다."));
    }

    public void deleteBoardPost(Long id) {
        boardPosts.stream()
            .filter(post->post.getId().equals(id))
            .findFirst()
            .orElseThrow(()->new IllegalArgumentException("id에 해당하는 글을 찾을 수 없습니다."));
    }
}