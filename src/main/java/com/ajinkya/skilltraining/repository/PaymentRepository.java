package com.ajinkya.skilltraining.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ajinkya.skilltraining.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	List<Payment> findByEnrollmentId(Long enrollmentId);
	List<Payment> findByEnrollmentStudentId(Long studentId);
	
	@Query("SELECT SUM(p.amount) FROM Payment p WHERE p.enrollment.id = :enrollmentId")
	double getTotalPaidByEnrollment(Long enrollmentId);
}
