package com.ksiegarnia.app.ksiazka;

import com.ksiegarnia.app.autor.Autor;
import com.ksiegarnia.app.autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ksiazki")
public class KsiazkaController {

    private final KsiazkaRepository ksiazkaRepository;
    private final AutorRepository autorRepository; // Do obsługi relacji

    @Autowired
    public KsiazkaController(KsiazkaRepository ksiazkaRepository, AutorRepository autorRepository) {
        this.ksiazkaRepository = ksiazkaRepository;
        this.autorRepository = autorRepository;
    }

    // /ksiazki?autorId={id}
    @GetMapping
    public List<Ksiazka> getAllKsiazki(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Long autorId // NOWY PARAMETR
    ) {
        if (autorId != null) {
            return ksiazkaRepository.findByAutorId(autorId);
        }
        return ksiazkaRepository.findAll();
    }

    // GET /ksiazki/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Ksiazka> getKsiazkaById(@PathVariable Long id) {
        return ksiazkaRepository.findById(id)
                .map(ksiazka -> ResponseEntity.ok(ksiazka))
                .orElse(ResponseEntity.notFound().build());
    }

    // // POST /ksiazki
    // @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    // public ResponseEntity<Ksiazka> createKsiazka(@RequestBody Ksiazka ksiazka) {
    //     // Sprawdzenie, czy autor istnieje przed zapisem książki
    //     if (ksiazka.getAutor() != null && ksiazka.getAutor().getId() != null) {
    //         Autor autor = autorRepository.findById(ksiazka.getAutor().getId())
    //                 .orElseThrow(() -> new RuntimeException("Autor o podanym ID nie istnieje"));
    //         ksiazka.setAutor(autor);
    //     }
    //     Ksiazka savedKsiazka = ksiazkaRepository.save(ksiazka);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(savedKsiazka);
    // }

    // // PUT /ksiazki/{id}
    // @PutMapping("/{id}")
    // public ResponseEntity<Ksiazka> updateKsiazka(@PathVariable Long id, @RequestBody Ksiazka ksiazkaDetails) {
    //     return ksiazkaRepository.findById(id)
    //             .map(ksiazka -> {
    //                 ksiazka.setTytul(ksiazkaDetails.getTytul());
    //                 ksiazka.setRokWydania(ksiazkaDetails.getRokWydania());
    //                 ksiazka.setIsbn(ksiazkaDetails.getIsbn());
                    
    //                 // Aktualizacja autora (wymaga podania ID autora w JSON)
    //                 if (ksiazkaDetails.getAutor() != null && ksiazkaDetails.getAutor().getId() != null) {
    //                     Autor autor = autorRepository.findById(ksiazkaDetails.getAutor().getId())
    //                             .orElseThrow(() -> new RuntimeException("Autor o podanym ID nie istnieje"));
    //                     ksiazka.setAutor(autor);
    //                 }
                    
    //                 Ksiazka updatedKsiazka = ksiazkaRepository.save(ksiazka);
    //                 return ResponseEntity.ok(updatedKsiazka);
    //             })
    //             .orElse(ResponseEntity.notFound().build());
    // }

    // // DELETE /ksiazki/{id}
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteKsiazka(@PathVariable Long id) {
    //     if (ksiazkaRepository.existsById(id)) {
    //         ksiazkaRepository.deleteById(id);
    //         return ResponseEntity.noContent().build();
    //     }
    //     return ResponseEntity.notFound().build();
    // }
}