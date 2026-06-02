package com.ajinkya.skilltraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajinkya.skilltraining.model.Course;
import com.ajinkya.skilltraining.model.Enrollment;
import com.ajinkya.skilltraining.model.Student;
import com.ajinkya.skilltraining.repository.CourseRepository;
import com.ajinkya.skilltraining.repository.EnrollmentRepository;
import com.ajinkya.skilltraining.repository.StudentRepository;

@Service
public class EnrollmentService {
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Enrollment> getAllEnrollments(){
		return enrollmentRepository.findAll();
	}
	
	public List<Enrollment> getEnrollmentsByStudent(Long studentId){
		return enrollmentRepository.findByStudentId(studentId);
	}
	
	public List<Enrollment> getEnrollmentsByCourse (Long courseId){
		return enrollmentRepository.findByCourseId(courseId);
	}
	
	public Enrollment createEnrollment (Long studentId, Long courseId, Enrollment enrollment) {
		Student student  = studentRepository.findById(studentId)
				.orElseThrow(()-> new RuntimeException("Student not found!"));
		
		Course course = courseRepository.findById(courseId)
				.orElseThrow(()-> new RuntimeException("Course not found!"));
		
		enrollment.setStudent(student);
		enrollment.setCourse(course);
		
		return enrollmentRepository.save(enrollment);
	}
	
	public void deleteEnrollment(Long id) {
		studentRepository.deleteById(id);
	}
}
