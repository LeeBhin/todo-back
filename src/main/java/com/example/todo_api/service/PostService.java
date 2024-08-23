package com.example.todo_api.service;


import com.example.todo_api.entity.Post;
import com.example.todo_api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllposts(){
        return postRepository.findAll();
    }

    public Optional<Post> getpostById(Long id){
        return postRepository.findById(id);
    }

    public Post createpost(Post post){
        return postRepository.save(post);
    }

    public Post updatepost(Long id,Post postDetails){
        Post post = postRepository.findById(id).orElseThrow(()-> new RuntimeException("post not found"));
        post.setTitle(postDetails.getTitle());
        post.setCompleted(postDetails.getCompleted());
        return postRepository.save((post));
    }

    public  void  deletepost(Long id){
        Post post = postRepository.findById(id).orElseThrow(()->new RuntimeException("post not found"));
        postRepository.delete(post);
    }

}