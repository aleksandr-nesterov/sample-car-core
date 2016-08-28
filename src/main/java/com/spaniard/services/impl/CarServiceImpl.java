package com.spaniard.services.impl;

import com.spaniard.model.Car;
import com.spaniard.repositories.CarRepository;
import com.spaniard.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alexander Nesterov
 * @version 1.0
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void save(final Car car) {
        carRepository.save(car);
    }
}
