package com.example.tba.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HaulierInput {
    @NotNull
    @Size(min=1)
    private String name;
}
