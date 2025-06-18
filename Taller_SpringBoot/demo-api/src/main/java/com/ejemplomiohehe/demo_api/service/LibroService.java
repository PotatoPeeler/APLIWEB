package main.java.com.ejemplomiohehe.demo_api.service;

import com.ejemplomiohehe.demo_api.model.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    private final List<Libro> libros = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Libro> obtenerTodos() {
        return libros;
    }

    public Optional<Libro> obtenerPorId(Long id) {
        return libros.stream().filter(l -> l.getId().equals(id)).findFirst();
    }

    public Libro crearLibro(Libro libro) {
        libro.setId(contadorId++);
        libros.add(libro);
        return libro;
    }

    public boolean eliminarLibro(Long id) {
        return libros.removeIf(l -> l.getId().equals(id));
    }

    public Libro actualizarLibro(Long id, Libro nuevoLibro) {
        Optional<Libro> existente = obtenerPorId(id);
        if (existente.isPresent()) {
            Libro libro = existente.get();
            libro.setTitulo(nuevoLibro.getTitulo());
            libro.setAutor(nuevoLibro.getAutor());
            return libro;
        } else {
            return null; // o lanzar excepción personalizada
        }
    }

    public Libro actualizarLibro(Long id, Libro nuevoLibro) {
        Optional<Libro> existente = obtenerPorId(id);
        if (existente.isPresent()) {
            Libro libro = existente.get();
            libro.setTitulo(nuevoLibro.getTitulo());
            libro.setAutor(nuevoLibro.getAutor());
            return libro;
        } else {
            return null; // o lanzar excepción si prefieres
        }
    }
}
