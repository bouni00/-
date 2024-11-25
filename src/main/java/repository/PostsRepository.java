package repository;

import dto.PostsResponseDto;
import entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Integer> {
    List<PostsResponseDto> findAllByOrderModifiedAtDesc();

}
