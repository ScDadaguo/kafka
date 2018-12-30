package com.example.kafka.deSerializer;




import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

/** 
* @Description: 反序列化器
* @Param:  
* @return:  
* @Author: 文兆杰
* @Date: 2018/12/20 
*/ 
public class ObjectDeserializer implements Deserializer<Object> {


    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        Object object =null;
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(data);

        try {
            ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
            object=inputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException();
        }

        System.out.println("topic:"+topic+",Deserialized Object :"+byteArrayInputStream);
        return object;
    }

    @Override
    public void close() {

    }
}
