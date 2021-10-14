package com.javabrains.springjpaconnection.service;

import com.javabrains.springjpaconnection.Repository.CourseRepository;
import com.javabrains.springjpaconnection.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
   private CourseRepository courseRepository;
    

    public List<Course> getAllCourses(String topicId){
        return courseRepository.findByTopicId(topicId);
    }

    public Course getCourse(String id){
//        return Courses.stream().filter(t->t.getId().equals(id)).findFirst().get();
       return courseRepository.findById(id).get();
    }

    public void addCourse(Course Course) {
//          Courses.add(Course);
        courseRepository.save(Course);
    }

    public void deleteCourse(String id) {
//        Courses.remove(id);
        courseRepository.deleteById(id);
    }

    public void updateCourse(Course newCourse) {
/*
       Optional<Course> t= Courses.stream().filter(Course -> Course.getId().equals(newCourse.getId())).findFirst();
        if(t.isPresent()){
            Courses.remove(t.get());
            Courses.add(newCourse);
        }
*/
      if(courseRepository.existsById(newCourse.getId())){
          courseRepository.save(newCourse);
      }

    }
}
