package com.ibergx00.springrest.RestApi.controllers;

import com.ibergx00.springrest.RestApi.Services.CourseService;
import com.ibergx00.springrest.RestApi.Services.CourseServiceImpl;
import com.ibergx00.springrest.RestApi.entities.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //annotation to make springboot know about MyController class(I created)
public class MyController {
    @Autowired //inject the obj of CourseService ie, impl class into courseService;
    private CourseService courseService;

    //get all the courses
    @GetMapping(name = "/courses", produces="application/json")
    public ResponseEntity<List<Course>> getCourses(){
        courseService = new CourseServiceImpl();
         return this.courseService.getCourses();
    }

    //get individual courses
    @GetMapping(name = "/courses/{courseId}",produces="application/json")
    public ResponseEntity<Course> getCourse(@PathVariable long courseId){
        return this.courseService.getCourse(courseId);
    }

    //adding courses
    @PostMapping(name="/courses",consumes = "application/json")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    //updating courses
    @PutMapping(name="/courses", consumes = "application/json")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    //deleting courses
    @DeleteMapping(name="/courses/{courseId}", consumes = "application/json")
    public ResponseEntity<Course> delCourse(@PathVariable long courseId){
       return this.courseService.delCourse(courseId);
    }


}
