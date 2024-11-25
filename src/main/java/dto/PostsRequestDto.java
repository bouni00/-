package dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostsRequestDto {
    private String title;
    private String content;
    private Integer authorId;
}
