package com.spaniard.repositories;

import com.spaniard.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Alexander Nesterov
 * @version 1.0
 */
@RepositoryRestResource(path = "cars")
public interface CarRepository extends CrudRepository<Car, Integer>{
}
