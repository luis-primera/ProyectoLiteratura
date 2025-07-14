package com.example.Modelo;
import com.example.Controlador.Autor;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    private String title;
    private List<Autor> authors;
    private List<String> languages;

    public String getTitle() {
        return title;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

}
