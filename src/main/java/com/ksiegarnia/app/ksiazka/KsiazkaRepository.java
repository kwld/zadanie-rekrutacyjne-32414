package com.ksiegarnia.app.ksiazka;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KsiazkaRepository extends JpaRepository<Ksiazka, Long> {
    // ID Autora
    List<Ksiazka> findByAutorId(Long autorId);
}