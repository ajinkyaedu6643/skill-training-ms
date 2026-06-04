package com.ajinkya.skilltraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajinkya.skilltraining.model.Payment;
import com.ajinkya.skilltraining.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/enrollment/{enrollmentId}")
	public Payment recordPayment(
			@PathVariable Long enrollmentId,
			@RequestBody Payment payment) {
		return paymentService.recordPayment(enrollmentId, payment);
	}
	
	@GetMapping("/enrollment/{enrollmentId}")
	public List<Payment> getByEnrollment(@PathVariable Long enrollmentId){
		return paymentService.getPaymentByEnrollment(enrollmentId);
	}
	
	@GetMapping("/student/{studentId}")
	public List<Payment> getByStudent(@PathVariable Long studentId){
		return paymentService.getPaymentByStudent(studentId);
	}
	
	@GetMapping("/total/enrollment/{enrollmentId}")
	public Double getTotalPaid(@PathVariable Long enrollmentId) {
		return paymentService.getTotalPaidByEnrollment(enrollmentId);
	}
	
}
