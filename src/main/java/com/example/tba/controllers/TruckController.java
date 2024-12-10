package com.example.tba.controllers;

import com.example.tba.entities.Truck;
import com.example.tba.input.TruckCreateInput;
import com.example.tba.input.TruckUpdateInput;
import com.example.tba.repositories.TruckHaulierRepository;
import com.example.tba.repositories.TruckRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class TruckController {
    private static final Logger logger = LoggerFactory.getLogger(TruckController.class);
    @Autowired
    TruckRepository truckRepository;
    @Autowired
    TruckHaulierRepository truckHaulierRepository;

    @GetMapping("/trucks")
    public List<Truck> findTrucks() {
        return truckRepository.findAll();
    }

    @GetMapping("/trucks/{id}")
    public Truck getTruckById(@PathVariable Short id) {
        return truckRepository.findById(id).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "No truck with id"));
    }
    @PostMapping("/trucks")
    public Truck createTruck(@Validated @RequestBody TruckCreateInput input) {
        final var truck = new Truck();
        truck.setRegistration(input.getRegistration());
        truck.setGross(input.getGross());
        truck.setTare(input.getTare());
        truck.setNett(input.getNett());
        truck.setHaulier(input.getHaulier());
        if (input.getGross() == 0 || input.getNett() == 0 || input.getTare() == 0) {
            logger.warn("Weight values 0 - perhaps not entered");
        }
        return truckRepository.save(truck);
    }

    @PostMapping("/trucks/{id}")
    public Truck updateTruck(@PathVariable Short id, @Validated @RequestBody TruckUpdateInput input) {
        final var truck = getTruckById(id);
        truck.setRegistration(input.getRegistration());
        truck.setGross(input.getGross());
        truck.setTare(input.getTare());
        truck.setNett(input.getNett());
        truck.setHaulier(input.getHaulier());
        if (input.getGross() == 0 || input.getNett() == 0 || input.getTare() == 0) {
            logger.warn("Weight values 0 - perhaps not entered");
        }
        return truckRepository.save(truck);
    }

    @DeleteMapping("/trucks/{id}")
    public String deleteTruck(@PathVariable Short id) {
        Truck truck = truckRepository.findById(id).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "No truck with id"));
        logger.info("Deleting truck id {}", id);
        truckRepository.deleteById(id);
        return "Truck was deleted";
    }

}
