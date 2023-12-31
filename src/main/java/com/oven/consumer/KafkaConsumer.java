package com.oven.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.consumer.topic}")
    public void consumer(String message) {
        System.out.printf("消费者接受到消息：\n%s\n", message);
    }
}
