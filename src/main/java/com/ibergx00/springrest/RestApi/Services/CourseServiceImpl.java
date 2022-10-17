package com.ibergx00.springrest.RestApi.Services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ibergx00.springrest.RestApi.dao.CourseDao;
import com.ibergx00.springrest.RestApi.entities.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    
    @Autowired
    private CourseDao courseDao;
    public CourseServiceImpl() {
        super();  
    }

    @Override
    public ResponseEntity<List<Course>> getCourses() {
        try{
            List<Course> course = this.courseDao.findAll();
            return ResponseEntity.of(Optional.of(course));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @Override
    public ResponseEntity<Course> getCourse(long courseId) {
        try{
            Course course = this.courseDao.getReferenceById(courseId);
            return ResponseEntity.of(Optional.of(course));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @Override
    public ResponseEntity<Course> addCourse(Course course) {
        try{
            this.courseDao.save(course);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @Override
    public ResponseEntity<Course> updateCourse(Course course){
        try{
            this.courseDao.save(course);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @Override
    public ResponseEntity<Course> delCourse(long courseId) throws EntityNotFoundException {
        try{
            Course coursey = this.courseDao.getReferenceById(courseId);
            courseDao.delete(coursey);
            return ResponseEntity.of(Optional.of(coursey));    
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
