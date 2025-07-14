package com.example.Controlador;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {
    private String name;

    public String getName() {
        return name;
    }
}
