package com.example.kafka.Serializer;

import com.example.kafka.domain.User;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;


/** 
* @Description: 序列化器
* @Param:  
* @return:  
* @Author: 文兆杰
* @Date: 2018/12/20 
*/ 
public class ObjectSerizlizer implements Serializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Object data) {


        System.out.println("topic:"+topic+",Object："+data);

        byte[] dataArray=null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);
            dataArray=outputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataArray;
    }

    @Override
    public void close() {

    }
}
