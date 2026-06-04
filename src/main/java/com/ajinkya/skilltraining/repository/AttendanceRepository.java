package com.ajinkya.skilltraining.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajinkya.skilltraining.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	
	List<Attendance> findByEnrollmentId(Long enrollmentId);
	List<Attendance> findByEnrollmentStudentId(Long studentId);
	List<Attendance> findByEnrollmentCourseId(Long courseId);
	
}
