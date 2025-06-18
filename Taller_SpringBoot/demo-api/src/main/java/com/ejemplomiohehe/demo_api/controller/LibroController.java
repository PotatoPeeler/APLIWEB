package main.java.com.ejemplomiohehe.demo_api.controller;

import com.ejemplomiohehe.demo_api.model.Libro;
import com.ejemplomiohehe.demo_api.service.LibroService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> listar() {
        return libroService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Libro> obtenerPorId(@PathVariable Long id) {
        return libroService.obtenerPorId(id);
    }

    @PostMapping
    public Libro crear(@RequestBody Libro libro) {
        return libroService.crearLibro(libro);
    }

    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return libroService.actualizarLibro(id, libro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = libroService.eliminarLibro(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }


}
