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

import com.ajinkya.skilltraining.model.Course;
import com.ajinkya.skilltraining.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id){
		return courseService.getCourseById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Course createCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
		courseService.deleteCourse(id);
		return ResponseEntity.ok().build();
	}
}
