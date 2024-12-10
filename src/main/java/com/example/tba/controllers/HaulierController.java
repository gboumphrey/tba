package com.example.tba.controllers;

import com.example.tba.entities.*;
import com.example.tba.repositories.TruckHaulierRepository;
import com.example.tba.repositories.HaulierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class HaulierController {
    @Autowired
    HaulierRepository haulierRepository;
    @Autowired
    TruckHaulierRepository truckHaulierRepository;

    @GetMapping("/hauliers")
    public List<Haulier> findHauliers() {
        return haulierRepository.findAll();
    }

    @GetMapping("/hauliers/{id}")
    public Haulier getFilmById(@PathVariable Short id) {
        return haulierRepository.findById(id).orElseThrow(()->new ResponseStatusException(NOT_FOUND, "No haulier with id"));
    }

}
