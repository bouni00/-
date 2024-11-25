package service;

import dto.PostsRequestDto;
import dto.PostsResponseDto;
import entity.Posts;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PostsRepository;

import java.util.List;

@Service
@Transactional
public class PostsService {
    @Autowired
    private PostsRepository postsRepository;

//    @Transactional
//    public List<PostsResponseDto> getPosts() {
//        return postsRepository.findAllByOrderModifiedAtDesc().stream().map(PostsResponseDto::new).toList();
//    }

    @Transactional
    public PostsResponseDto createPosts(PostsRequestDto postsRequestDto) {
        Posts posts;
        posts = Posts.toEntity(postsRequestDto);
        postsRepository.save(posts);
        return new PostsResponseDto(posts);
    }

    @Transactional
    public PostsResponseDto getPost(Integer postId) {
        return postsRepository.findById(postId).map(PostsResponseDto::new).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
    }

    @Transactional
    public PostsResponseDto updatePost(Integer postId, PostsRequestDto postsRequestDto) throws Exception {
        Posts posts = postsRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        posts.update(postsRequestDto);
        return new PostsResponseDto(posts);
    }

    public int deletePost(Integer postId)throws Exception  {
        postsRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        postsRepository.deleteById(postId);
        return 1;
    }
}
