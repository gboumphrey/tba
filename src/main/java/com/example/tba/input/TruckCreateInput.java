package com.example.tba.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class TruckCreateInput {
    @NotNull
    @Size(min=1, max=45)
    private String registration;
    @NotNull
    @Size(min=1, max=45)
    private String haulier;
    @NotNull
    private Double gross;
    @NotNull
    private Double tare;
    @NotNull
    private Double nett;
    private Short id;
}
