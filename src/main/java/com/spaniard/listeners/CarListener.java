package com.spaniard.listeners;

import com.spaniard.model.Car;
import com.spaniard.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Nesterov
 * @version 1.0
 */

@Component
public class CarListener {

    @Autowired
    private CarService carService;

    @KafkaListener(topics = "car.topic")
    public void onMessage(final Car car) {
        System.out.println("Incoming message: " + car);
        carService.save(car);
    }
}
