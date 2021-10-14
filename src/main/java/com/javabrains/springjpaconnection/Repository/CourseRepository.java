package com.javabrains.springjpaconnection.Repository;

import com.javabrains.springjpaconnection.model.Course;
import com.javabrains.springjpaconnection.model.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {


//    public List<Course> findByName(String name);
    public List<Course> findByTopicId(String topicId);
}
