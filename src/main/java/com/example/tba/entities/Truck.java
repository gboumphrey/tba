package com.example.tba.entities;

import jakarta.persistence.*;

@Entity
@Table(name="truck")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="truck_id")
    private Short id;
    @Column(name="registration")
    private String registration;
    @Column(name="gross_weight")
    private double gross;
    @Column(name="tare_weight")
    private double tare;
    @Column(name="nett_weight")
    private double nett;
    @Column(name="haulier")
    private String haulier;

    public Truck(){}
    public Truck(String registration, double gross, double tare, double nett, String haulier){
        this.registration = registration;
        this.gross = gross;
        this.tare = tare;
        this.nett = nett;
        this.haulier = haulier;

    }

    @ManyToOne
    @JoinTable(
            name = "truck_haulier",
            joinColumns = {@JoinColumn(name = "truck_id")},
            inverseJoinColumns = {@JoinColumn(name = "haulier_id")}
    )

    public Short getId() {
        return id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public double getTare() {
        return tare;
    }

    public void setTare(double tare) {
        this.tare = tare;
    }

    public double getNett() {
        return nett;
    }

    public void setNett(double nett) {
        this.nett = nett;
    }

    public String getHaulier() {
        return haulier;
    }

    public void setHaulier(String haulier) {
        this.haulier = haulier;
    }
}
