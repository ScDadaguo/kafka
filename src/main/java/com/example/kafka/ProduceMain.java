package com.example.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

public class ProduceMain {
    public static void main(String[] args) throws Exception {
        Properties properties=new Properties();
        properties.setProperty("bootstrap.servers","192.168.40.128:9092,192.168.40.129:9092,192.168.40.130:9092");
        //properties是一个hashtable
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", StringSerializer.class);
        KafkaProducer kafkaProducer=new KafkaProducer(properties);
        ProducerRecord<String,String> producerRecord=new ProducerRecord("sf",0,"message","helloword");
        Future<RecordMetadata> future= kafkaProducer.send(producerRecord);
        RecordMetadata recordMetadata=future.get();
        System.out.println(recordMetadata);
//        我就是随便加一个试试

    }
}
