package com.sparta.scheduler.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "Schedule")
public class Schedule {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private long id;

    private String userName;
    private String todoTitle;
    private String todoContent;

    // 댓글 리스트
    // 댓글 리스트 (Comment가 엔티티인 경우)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "schedule_id")
    private List<Comment> comments = new ArrayList<>();

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;


    public Schedule() {
        createdDate = LocalDateTime.now();
        lastModifiedDate = LocalDateTime.now();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        // comment.setId(id);
    }
}
