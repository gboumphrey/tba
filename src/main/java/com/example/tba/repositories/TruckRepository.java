package com.example.tba.repositories;

import com.example.tba.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Short> {
}
