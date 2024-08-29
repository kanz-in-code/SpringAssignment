package com.sparta.scheduler.controller;

import com.sparta.scheduler.dto.Comment;
import com.sparta.scheduler.dto.Schedule;
import com.sparta.scheduler.service.CommentService;
import com.sparta.scheduler.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CommentService commentService;

    // 일정 저장
    @PostMapping("/api/schedule")
    public ResponseEntity<Schedule> saveSchedule(@RequestBody Schedule schedule) {
        Schedule savedSchedule = scheduleService.save(schedule);
        return ResponseEntity.ok(savedSchedule);
    }

    // 단건 일정 조회
    @GetMapping("/api/schedules/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        Optional<Schedule> schedule = scheduleService.getScheduleById(id);
        return schedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 일정 수정
    @Transactional
    @PutMapping("/api/schedules/{id}")
    public ResponseEntity<Schedule> updateScheduleById(@PathVariable Long id, @RequestBody Schedule schedule) {
        String content = schedule.getTodoContent();
        Schedule updated = scheduleService.updateContentById(id, content);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/schedules/{id}/comment")
    public ResponseEntity<Schedule> saveComment(@PathVariable Long id, @RequestBody Comment comment) {
        Schedule schedule = scheduleService.getScheduleById(id).orElse(null);
        if (schedule != null) {
            schedule.addComment(comment);
            commentService.save(comment);
            log.info("schedule : {}", schedule);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/schedules/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteScheduleById(id);
        return ResponseEntity.ok().build();
    }
}
