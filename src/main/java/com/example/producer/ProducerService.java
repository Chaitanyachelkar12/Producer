package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final String TOPIC = "Test";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendInitialMessage(String message) throws InterruptedException {
        kafkaTemplate.send(TOPIC, message);
        System.out.println(" Producer sent: " + message);
        Thread.sleep(5000);
    }

    // Optional: Listen to messages echoed back by consumer
    @KafkaListener(topics = TOPIC)
    public void onMessage(String message) throws InterruptedException {
        if (message.contains("processed by Consumer")) {
            System.out.println(" Producer received: " + message);
            String newMsg = message + " | echoed by Producer";
            kafkaTemplate.send(TOPIC, newMsg);
            System.out.println(" Producer sent again to same topic");
            Thread.sleep(5000);
        }
    }
}
