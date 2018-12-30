package com.example.kafka.consumer;

import com.example.kafka.domain.User;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

public class CustomerListener {

    @KafkaListener(topics = "sf")
    public void  consumer(String message){
        System.out.println(message);
    }

    @KafkaListener(topics = "sf")
    public void consumer(User user){
        System.err.println(user);
    }
}
