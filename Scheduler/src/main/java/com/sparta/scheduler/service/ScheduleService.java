package com.sparta.scheduler.service;

import com.sparta.scheduler.dto.Comment;
import com.sparta.scheduler.dto.Schedule;
import com.sparta.scheduler.repository.CommentRepository;
import com.sparta.scheduler.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private CommentRepository commentRepository;

    // 일정 저장
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // 단건 일정 조회
    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    // 일정 수정
    public Schedule updateContentById(Long id, String content) {
        Schedule schedule = scheduleRepository.findById(id).orElse(null);
        if (schedule != null) {
            schedule.setTodoContent(content);
        }

        return schedule;
    }

    public void deleteScheduleById(Long id) {
        scheduleRepository.deleteById(id);
    }


}
