package com.ibergx00.springrest.RestApi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lalacourse")
public class Course {
    @Id
    private long id;
    private String title; 
    private String description;
    public Course(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Course() {
        super();
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Course [description=" + description + ", id=" + id + ", title=" + title + "]";
    }
    
}
