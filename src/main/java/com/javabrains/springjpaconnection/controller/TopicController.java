package com.javabrains.springjpaconnection.controller;

import com.javabrains.springjpaconnection.model.Topic;
import com.javabrains.springjpaconnection.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class TopicController {

    @Autowired
    TopicService topicService;

 @RequestMapping(method=RequestMethod.GET, value="/topics")
    public List<Topic> getTopics(){
  return topicService.getAllTopics();
    }

    @RequestMapping(method=RequestMethod.GET, value="/topics/{id}")
    public Topic getTopics(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/topics")
    public void getTopics(@RequestBody Topic topic){
     topicService.addTopic(topic);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics")
    public void updateTopics(@RequestBody Topic topic){
        topicService.updateTopic(topic);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable String id){
         topicService.deleteTopic(id);
    }
}
