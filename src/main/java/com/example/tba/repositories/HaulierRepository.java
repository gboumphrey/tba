package com.example.tba.repositories;

import com.example.tba.entities.Haulier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HaulierRepository extends JpaRepository<Haulier, Short> {
}
