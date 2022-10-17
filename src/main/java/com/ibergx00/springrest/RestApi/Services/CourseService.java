package com.ibergx00.springrest.RestApi.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ibergx00.springrest.RestApi.entities.Course;

public interface CourseService {
    //for loose coupling
    public ResponseEntity<List<Course>> getCourses();
    public ResponseEntity<Course> getCourse(long courseId);
    public ResponseEntity<Course> addCourse(Course course);
    public ResponseEntity<Course> updateCourse(Course course);
    public ResponseEntity<Course> delCourse(long courseId);
}
