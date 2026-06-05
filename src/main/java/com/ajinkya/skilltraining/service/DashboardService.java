package com.ajinkya.skilltraining.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajinkya.skilltraining.repository.CourseRepository;
import com.ajinkya.skilltraining.repository.EnrollmentRepository;
import com.ajinkya.skilltraining.repository.PaymentRepository;
import com.ajinkya.skilltraining.repository.StudentRepository;

@Service
public class DashboardService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public Map<String, Object> getDashboardStats(){
		Map<String, Object> stats = new HashMap<> ();
		
		stats.put("totalStudents", studentRepository.count());
		stats.put("totalCourse", courseRepository.count());
		stats.put("totalEnrollments", enrollmentRepository.count());
		
		Double totalRevenue = paymentRepository.findAll()
				.stream()
				.mapToDouble(p -> p.getAmount())
				.sum();
		stats.put("totalRevenue", totalRevenue);
		
		return stats;
	}
	
}
