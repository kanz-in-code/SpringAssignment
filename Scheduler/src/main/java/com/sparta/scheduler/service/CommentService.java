package com.sparta.scheduler.service;

import com.sparta.scheduler.dto.Comment;
import com.sparta.scheduler.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Service > 비즈니스 로직을 담당한다.
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    public Comment save(Comment comment) {
        comment.setComment(comment.getComment() + "~ 안녕하세요");
        return commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

}
