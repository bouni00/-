package dto;

import entity.Posts;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostsResponseDto {

    private Integer postId;
    private String title;
    private String content;
    private Integer authorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer views;
    private boolean isDeleted;

    public PostsResponseDto(Posts entity) {
        this.postId = entity.getPostId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.authorId = entity.getAuthorId();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
        this.views = entity.getViews();
    }

}