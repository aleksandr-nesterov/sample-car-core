package com.spaniard.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *  @author Alexander Nesterov
 *  @version 1.0
 */
@Data
@Entity
public class Car {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String model;
    private Integer year;

    private Car() {
    }
}
