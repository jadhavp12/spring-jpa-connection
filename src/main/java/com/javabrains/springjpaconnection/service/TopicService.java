package com.javabrains.springjpaconnection.service;

import com.javabrains.springjpaconnection.Repository.TopicRepository;
import com.javabrains.springjpaconnection.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
   private TopicRepository topicRepository;

    private List<Topic> topics= new ArrayList<>(
            Arrays.asList(
                    new Topic("java","core java","core java- java 8"),
                    new Topic("spring","spring boot","spring boot project"),
                    new Topic("angular","angular 12","latest angular version")
                    ));

    public List<Topic> getAllTopics(){
//        return topics;
        List<Topic> topics=new ArrayList<>();
//        topicRepository.findAll().forEach(topic -> topics.add(topic));
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
//        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
       return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {
//          topics.add(topic);
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.remove(id);
        topicRepository.deleteById(id);
    }

    public void updateTopic(Topic newtopic) {
/*
       Optional<Topic> t= topics.stream().filter(topic -> topic.getId().equals(newtopic.getId())).findFirst();
        if(t.isPresent()){
            topics.remove(t.get());
            topics.add(newtopic);
        }
*/
      if(topicRepository.existsById(newtopic.getId())){
          topicRepository.save(newtopic);
      }

    }
}
