package com.ajinkya.skilltraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajinkya.skilltraining.model.Attendance;
import com.ajinkya.skilltraining.model.Enrollment;
import com.ajinkya.skilltraining.repository.AttendanceRepository;
import com.ajinkya.skilltraining.repository.EnrollmentRepository;

@Service
public class AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	public Attendance markAttendance (Long enrollmentId, Attendance attendance) {
		Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
				.orElseThrow(()-> new RuntimeException("Enrollment not found!"));
		
		attendance.setEnrollment(enrollment);
		return attendanceRepository.save(attendance);
	}
	
	public List<Attendance> getAttendanceByEnrollment(Long enrollmentId){
		return attendanceRepository.findByEnrollmentId(enrollmentId);
	}
	
	public List<Attendance> getAttendanceByStudent(Long studentId){
		return attendanceRepository.findByEnrollmentStudentId(studentId);
	}
	
	public List<Attendance> getAttendanceByCourse(Long courseId){
		return attendanceRepository.findByEnrollmentCourseId(courseId);
	}
	
	public double getAttendancePercentage(Long enrollmentId) {
		List<Attendance> records = attendanceRepository.findByEnrollmentId(enrollmentId);
		if(records.isEmpty()) return 0.0;
		
		long present = records.stream()
				.filter(a -> a.getStatus()== Attendance.Status.PRESENT)
				.count();
		
		return (double) present / records.size()*100;
	}
	
	
}
