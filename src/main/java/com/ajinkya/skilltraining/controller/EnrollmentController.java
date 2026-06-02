package com.ajinkya.skilltraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajinkya.skilltraining.model.Enrollment;
import com.ajinkya.skilltraining.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
	
	@Autowired
	private EnrollmentService enrollmentService;
	
	@GetMapping
	public List<Enrollment> getEnrollments(){
		return enrollmentService.getAllEnrollments();
	}
	
	@GetMapping("/student/{studentId}")
	public List<Enrollment> getEnrollmentsByStudentId(@PathVariable Long studentId){
		return enrollmentService.getEnrollmentsByStudent(studentId);
	}
	
	@GetMapping("/course/{courseId}")
	public List <Enrollment> getEnrollmentsByCourseId(@PathVariable Long courseId){
		return enrollmentService.getEnrollmentsByCourse(courseId);
	}
	
	@PostMapping("/student/{studentId}/course/{courseId}")
	public Enrollment createEnrollment(
			@PathVariable Long studentId,
			@PathVariable Long courseId,
			@RequestBody Enrollment enrollment){
		return enrollmentService.createEnrollment(studentId, courseId, enrollment);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id){
		enrollmentService.deleteEnrollment(id);
		return ResponseEntity.ok().build();
	}
}
