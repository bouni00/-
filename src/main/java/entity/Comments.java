package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    private Integer postId;
    private Integer parentCommentId;
    private String content;
    private Integer authorId;
    private LocalDateTime createdAt;
    private boolean isDeleted;
}
