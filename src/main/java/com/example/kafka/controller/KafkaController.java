package com.example.kafka.controller;

import com.example.kafka.domain.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {
    private final KafkaTemplate<String,Object> kafkaTemplate;


    public KafkaController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @RequestMapping(value = "/message/send",method = RequestMethod.GET)
    public String sendMessage(@RequestParam String message){
        kafkaTemplate.send("sf","key",message);
        return message;
    }

    @RequestMapping(value = "/user/save",method = RequestMethod.POST)
    public User saveUser(@RequestBody  User user){
        kafkaTemplate.send("sf", 0, "key", user);
        return user;
    }
}
