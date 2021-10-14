package com.javabrains.springjpaconnection.controller;

import com.javabrains.springjpaconnection.model.Course;
import com.javabrains.springjpaconnection.model.Topic;
import com.javabrains.springjpaconnection.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

 @RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses")
    public List<Course> getCourses(@PathVariable String topicId){
    return courseService.getAllCourses(topicId);
    }

    @RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
     course.setTopic(new Topic(topicId,"",""));
     courseService.addCourse(course);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateTopics(@RequestBody Course course, @PathVariable String topicId ,@PathVariable String id){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable String id){
         courseService.deleteCourse(id);
    }
}
