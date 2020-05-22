package com.in28minutes.springboot.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.in28minutes.springboot.model.Course;
import com.in28minutes.springboot.model.Student;

@Component
public class StudentService {

public List<Course> retrieveCourses(String studentId) {
    Map<String, Course> courses = Student.getStudentObj(studentId).getCourses();
    List<Course> courseList = 
    courses.values().parallelStream().collect(Collectors.toList());
    return courseList;
 }

 public Course retrieveCourse(String studentId, String courseId) {
    return Student.getStudentObj(studentId).getCourses().get(courseId);
 }