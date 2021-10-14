package com.javabrains.springjpaconnection.Repository;

import com.javabrains.springjpaconnection.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
