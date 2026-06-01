package com.ajinkya.skilltraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajinkya.skilltraining.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
