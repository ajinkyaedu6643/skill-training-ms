package com.ajinkya.skilltraining.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajinkya.skilltraining.model.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	
	List<Enrollment> findByStudentId(Long studentId);
	List<Enrollment> findByCourseId(Long courseId);
	
}
