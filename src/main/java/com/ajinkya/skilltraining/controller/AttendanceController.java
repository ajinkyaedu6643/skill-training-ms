package com.ajinkya.skilltraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajinkya.skilltraining.model.Attendance;
import com.ajinkya.skilltraining.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	@PostMapping("/enrollment/{enrollmentId}")
	public Attendance markAttendance(
			@PathVariable Long enrollmentId,
			@RequestBody Attendance attendance) {
		return attendanceService.markAttendance(enrollmentId, attendance);
	}
	
	@GetMapping("/enrtollment/{enrollmentId}")
	public List<Attendance> getByEnrollment(@PathVariable Long enrollmentId){
		return attendanceService.getAttendanceByEnrollment(enrollmentId);
	}
	
	@GetMapping("/student/{studentId}")
	public List<Attendance> getByStudent(@PathVariable Long studentId){
		return attendanceService.getAttendanceByStudent(studentId);
	}
	
	@GetMapping("/course/{courseId}")
	public List<Attendance> getByCourse(@PathVariable Long courseId){
		return attendanceService.getAttendanceByCourse(courseId);
	}
	
	@GetMapping("/percentage/enrollment/{enrollmentId}")
	public double getAttendancePercentage(@PathVariable Long enrollmentId) {
		return attendanceService.getAttendancePercentage(enrollmentId);
	}
	
	
}
