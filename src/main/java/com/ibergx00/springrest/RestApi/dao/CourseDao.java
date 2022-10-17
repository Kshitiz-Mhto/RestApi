package com.ibergx00.springrest.RestApi.dao;

import com.ibergx00.springrest.RestApi.entities.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {
    
}
