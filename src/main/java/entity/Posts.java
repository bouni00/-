package entity;

import dto.PostsRequestDto;
import dto.PostsResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String title;
    private String content;
    private Integer authorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer views;
    private boolean isDeleted;

    public static Posts toEntity(PostsRequestDto dto) {
        return Posts.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .authorId(dto.getAuthorId())
                .build();
    }

    public void update(PostsRequestDto postsRequestDto) {
    }
}
