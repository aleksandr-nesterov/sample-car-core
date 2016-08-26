package com.spaniard;

import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author Alexander Nesterov
 * @version 1.0
 */

public class CarListener {

    @KafkaListener(topics = "car.topic")
    public void onMessage(String message) {
        System.out.println("Incoming message: " + message);
    }
}
