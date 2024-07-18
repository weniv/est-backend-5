package net.chimaek.day0717_restapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board-post")
public class BoardPostController {

    private final BoardPostService boardPostService;

    @Autowired
    public BoardPostController(BoardPostService boardPostService) {
        this.boardPostService = boardPostService;
    }

    @PostMapping
    public ResponseEntity<BoardPostDto> createBoardPost(@RequestBody BoardPostDto boardPostDto) {
        BoardPostDto createdBoardPostDto = boardPostService.createBoardPost(boardPostDto);
        return ResponseEntity.ok(createdBoardPostDto);
    }

    @GetMapping
    public ResponseEntity<List<BoardPostDto>> getAllBoardPosts() {
        List<BoardPostDto> boardPostDtos = boardPostService.getAllBoardPosts();
        return ResponseEntity.ok(boardPostDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardPostDto> getBoardPostById(@PathVariable("id") Long id) {
        BoardPostDto boardPostDto = boardPostService.getBoardPostDtoById(id);
        return ResponseEntity.ok(boardPostDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoardPost(@PathVariable("id") Long id) {
        boardPostService.deleteBoardPost(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardPostDto> updateBoardPost(@PathVariable("id") Long id, @RequestBody
    BoardPostDto updateBoardPostDto) {
        BoardPostDto updatedBoardPostDto = boardPostService.updateBoardPost(id, updateBoardPostDto);

        return ResponseEntity.ok(updatedBoardPostDto);
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(
        @PathVariable("postId") Long postId, @RequestBody CommentDto createCommentDto
    ){
        CommentDto createdCommentDto = boardPostService.createComment(postId,createCommentDto);
        return ResponseEntity.ok(createdCommentDto);
    }

}