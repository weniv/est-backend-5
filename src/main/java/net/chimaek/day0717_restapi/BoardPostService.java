package net.chimaek.day0717_restapi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
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
    private static CommentDto convertToCommentDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setAuthor(comment.getAuthor());
        commentDto.setCreatedAt(comment.getCreatedAt());
        return commentDto;
    }

}