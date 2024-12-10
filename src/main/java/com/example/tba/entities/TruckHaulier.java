package com.example.tba.entities;

import jakarta.persistence.*;

@Entity
@Table(name="film_actor")
@IdClass(TruckHaulierId.class)
public class TruckHaulier {
    @Id
    @Column(name="truck_id")
    private Short truckId;
    @Id
    @Column(name="haulier_id")
    private Short haulierId;

    public void setFilmId(Short filmId) {
        this.truckId = truckId;
    }

    public void setActorId(Short actorId) {
        this.haulierId = haulierId;
    }
}
