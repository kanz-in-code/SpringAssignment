package com.sparta.scheduler.repository;

import com.sparta.scheduler.dto.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Class, PK Type>
// Repositor > DB 에 직접 I/O
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
