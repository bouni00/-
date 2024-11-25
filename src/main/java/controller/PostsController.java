package controller;

import dto.PostsRequestDto;
import dto.PostsResponseDto;
import entity.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PostsService;

import java.util.List;

@RestController
public class PostsController {
    @Autowired
    private PostsService postsService;

    @GetMapping("/posts")
    public List<PostsResponseDto> getPosts() {
        return postsService.getPosts();
    }

    @PostMapping("/posts")
    public PostsResponseDto createPosts(@RequestBody PostsRequestDto postsRequestDto) {
        return postsService.createPosts(postsRequestDto);
    }

    @GetMapping("/posts/{postId}")
    public PostsResponseDto getPost(@PathVariable Integer postId) {
        return postsService.getPost(postId);
    }

    @PutMapping("/posts/{postId}")
    public PostsResponseDto updatePost(@PathVariable Integer postId, PostsRequestDto postsRequestDto) throws Exception {
        return postsService.updatePost(postId, postsRequestDto);
    }

    @DeleteMapping("/posts/{postId}")
    public int deletePost(@PathVariable Integer postId)throws Exception  {
        int result = 0;
        result = postsService.deletePost(postId);
        return result;
    }
}