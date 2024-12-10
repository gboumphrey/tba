package com.example.tba.controllers;

import com.example.tba.entities.Truck;
import com.example.tba.input.TruckCreateInput;
import com.example.tba.input.TruckUpdateInput;
import com.example.tba.repositories.TruckHaulierRepository;
import com.example.tba.repositories.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class TruckController {
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
        return truckRepository.save(truck);
    }

    @DeleteMapping("/trucks/{id}")
    public void deleteTruck(@PathVariable Short id) {
        Truck truck = truckRepository.findById(id).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "No truck with id"));
        truckRepository.deleteById(id);
    }

}
