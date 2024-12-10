package com.example.tba.repositories;

import com.example.tba.entities.TruckHaulier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckHaulierRepository extends JpaRepository<TruckHaulier, Short> {
}
