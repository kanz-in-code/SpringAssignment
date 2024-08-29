package com.sparta.scheduler.repository;

import com.sparta.scheduler.dto.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}