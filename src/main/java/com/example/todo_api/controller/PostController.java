package com.example.todo_api.controller;


import com.example.todo_api.entity.Post;
import com.example.todo_api.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllposts();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Post> getAllPosts(@PathVariable Long id) {

        Post post = postService.getpostById(id).orElseThrow(() -> new RuntimeException("post not found"));

        return ResponseEntity.ok(post);
    }

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post) {
        return postService.createpost(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody Post postDetails) {
        Post updatepost = postService.updatepost(id, postDetails);
        return ResponseEntity.ok(updatepost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id){
        log.info("delete post {}", id);
        postService.deletepost(id);
        return ResponseEntity.ok().build();
    }
}