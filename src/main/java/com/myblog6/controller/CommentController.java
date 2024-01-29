package com.myblog6.controller;

import com.myblog6.payload.CommentDto;
import com.myblog6.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8080/api/posts/2/comments
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                                    @RequestBody CommentDto commentDto){
        return new ResponseEntity<CommentDto>(commentService.createComment(postId,
                commentDto), HttpStatus.CREATED);
    }
    //http://localhost:8080/api/posts/2/comments
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId")Long postId){
        return commentService.getCommentsByPostId(postId);
    }
    //http://localhost:8080/api/posts/2/comments/3
    @GetMapping("/posts/{postId}/commentId{commentId}")
    public CommentDto getCommentsById(@PathVariable(value = "postId")Long postId,
                                          @PathVariable(value = "commentId")Long commentId){
        return commentService.getCommentsById(postId, commentId);
    }
    //http://localhost:8080/api/comments
    @GetMapping("/comments")
    public List<CommentDto> getAllCommentsById(){
        return commentService.getAllCommentsById();
    }
    @DeleteMapping("/posts/{postId}/commentId{commentId}")
    public ResponseEntity<String> deleteCommentById(
            @PathVariable(value = "postId")Long postId,
            @PathVariable(value = "commentId")Long commentId
    ){
     commentService.deleteCommentById(postId, commentId);
     return new ResponseEntity<>("Comment is deleted",HttpStatus.OK);
    }
}



