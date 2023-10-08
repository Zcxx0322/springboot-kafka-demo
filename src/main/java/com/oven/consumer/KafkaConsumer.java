package com.oven.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class KafkaConsumer {

    @Value("${kafka.consumer.topic}")
    private String consumerTopic;

    @KafkaListener(topics = "${kafka.consumer.topic}")
    public void consumer(String message) {
        System.out.printf("消费者接受到消息：%s", message);
    }
}