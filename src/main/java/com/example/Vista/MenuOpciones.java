package com.example.Vista;

import com.example.Modelo.Libro;
import com.example.Controlador.LibroApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOpciones {

    static List<Libro> librosGuardados = new ArrayList<>(); // Para los libros guardados

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Entrada para el usuario en la consola
        LibroApi servicio = new LibroApi();

        int opcion; // Se declara la variable antes del do-while

        do {
            mostrarMenu();  // Muestra menu luego de cada interacción
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Escriba por favor el nombre del libro que desea buscar: ");
                    String nombreLibro = scanner.nextLine();
                    Libro libro = servicio.buscarLibroPorNombre(nombreLibro);
                    if (libro != null) {
                        librosGuardados.add(libro);
                        System.out.println("///////////****************ffffffffffffffffff");// Agrega el libro a la lista
                        System.out.println(libro.getTitle());
                        System.out.println(libro.getAuthors().get(0).getName());
                        System.out.println(libro.getLanguages());
                    }
                    break;
                case 2:
                    if (librosGuardados.isEmpty()) {
                        System.out.println("No hay libros guardados.");
                    } else {
                        System.out.println("Libros registrados:");
                        for (Libro l : librosGuardados) {
                            System.out.println(l.toString());
                            System.out.println(); // Línea en blanco entre libros
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("La opción no es válida. Por favor intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n----- MENÚ DE OPCIONES -----");
        System.out.println("1 - Buscar libro");
        System.out.println("2 - Listar libros registrados");
        System.out.println("3 - Listar autores registrados");
        System.out.println("4 - Listar autores vivos en un año");
        System.out.println("5 - Listar libros por idioma");
        System.out.println("0 - Salir");
    }
}
