package com.oven.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException; // 导入Jackson库
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@SuppressWarnings("unused")
@Component
public class KafkaProducer {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.producer.id}")
    private String producerId;

    @Value("${spring.kafka.producer.default-topic}")
    private String defaultTopic;

    public void send(String message) {
        String timestamp = new Date().toString();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("producerId", producerId);
            jsonNode.put("message", message);
            jsonNode.put("timestamp", timestamp);
            jsonNode.put("topic", defaultTopic);

            String messageToSend = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

            kafkaTemplate.send(defaultTopic, messageToSend);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public String getProducerId() {
        return producerId;
    }
    public String getDefaultTopic() {
        return defaultTopic;
    }
}
