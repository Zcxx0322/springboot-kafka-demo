package com.oven.controller;

import com.oven.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@SuppressWarnings("unused")
@RestController
public class DemoController {

    @Autowired
    private KafkaProducer producer;

    @RequestMapping("/send")
    public String send(@RequestParam String msg) {
        String timestamp = new Date().toString();
        String response = String.format("{\n  \"producerId\" : \"%s\",\n  \"message\" : \"%s\",\n  \"timestamp\" : \"%s\",\n  \"topic\" : \"%s\"\n}",
                producer.getProducerId(), msg, timestamp, producer.getDefaultTopic());

        // 发送消息到Kafka
        producer.send(msg);

        return response;
    }
}

