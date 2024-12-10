package com.example.tba.input;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TruckUpdateInput {
    @Size(min=1, max=45)
    private String registration;
    @Size(min=1, max=45)
    private String haulier;
    private double gross;
    private double tare;
    private double nett;
    private Short id;
}
