package com.example.Controlador;

import com.example.Modelo.Libro;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LibroApi {

    public Libro buscarLibroPorNombre(String nombreLibro) {
        try {
            String libroCodificado = URLEncoder.encode(nombreLibro, StandardCharsets.UTF_8);
            String url = "https://gutendex.com/books/?search=" + libroCodificado.trim();


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            LibroResponse libroResponse = mapper.readValue(response.body(), LibroResponse.class);

            for (Libro libro : libroResponse.getResults()) {
                System.out.println("📖 Título: " + libro.getTitle());

                if (libro.getAuthors() != null && !libro.getAuthors().isEmpty()) {
                    System.out.println("✍️ Autor: " + libro.getAuthors().get(0).getName());
                } else {
                    System.out.println("✍️ Autor: Desconocido");
                }

                if (libro.getLanguages() != null && !libro.getLanguages().isEmpty()) {
                    System.out.println("🌍 Idioma: " + libro.getLanguages().get(0));
                } else {
                    System.out.println("🌍 Idioma: Desconocido");
                }

                System.out.println("----------------------------");
                return libro;
            }

        } catch (Exception e) {
            System.out.println(" Error al buscar el libro: " + e.getMessage());
            return null;
        }
        return null;
    }
}
