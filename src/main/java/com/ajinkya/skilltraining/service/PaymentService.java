package com.ajinkya.skilltraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajinkya.skilltraining.model.Enrollment;
import com.ajinkya.skilltraining.model.Payment;
import com.ajinkya.skilltraining.repository.EnrollmentRepository;
import com.ajinkya.skilltraining.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private EnrollmentRepository enrollmentrepository;
	
	public Payment recordPayment(Long enrollmentId, Payment payment) {
		Enrollment enrollment = enrollmentrepository.findById(enrollmentId)
				.orElseThrow(()-> new RuntimeException("Enrollment not found!"));
		
		payment.setEnrollment(enrollment);
		return paymentRepository.save(payment);
	}
	
	public List<Payment> getPaymentByEnrollment(Long enrollmentId){
		return paymentRepository.findByEnrollmentId(enrollmentId);
	}
	
	public List<Payment> getPaymentByStudent (Long studentId){
		return paymentRepository.findByStudentId(studentId);
	}
	
	public Double getTotalPaidByEnrollment(Long enrollmentId) {
		Double total = paymentRepository.getTotalPaidByEnrollment(enrollmentId);
		return total != null ? total :0.0;
	}
}
