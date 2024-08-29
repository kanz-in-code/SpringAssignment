package com.sparta.scheduler.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@ToString
public class Comment {

    // 댓글 내용, 작성일, 수정일, 작성 유저명
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Inrements
    private long id;

    private String userName;
    private String comment;
    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedTime;

    public Comment() {
        createdTime = LocalDateTime.now();
        lastModifiedTime = LocalDateTime.now();
    }

}
