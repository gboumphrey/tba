package com.example.tba.entities;

import jakarta.persistence.*;

@Entity
@Table(name="haulier")
public class Haulier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "haulier_id")
    private Short id;
    @Column(name = "name")
    private String name;

    public Short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}