package com.ksiegarnia.app.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/autorzy")
public class AutorController {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    // GET /autorzy
    @GetMapping
    public List<Autor> getAllAutors(@RequestParam(required = false) String search) {
        return autorRepository.findAll();
    }

    // GET /autorzy/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id) {
        return autorRepository.findById(id)
                .map(autor -> ResponseEntity.ok(autor))
                .orElse(ResponseEntity.notFound().build());
    }
}