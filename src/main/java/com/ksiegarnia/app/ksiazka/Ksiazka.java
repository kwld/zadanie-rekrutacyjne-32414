package com.ksiegarnia.app.ksiazka;

import com.ksiegarnia.app.autor.Autor;
import jakarta.persistence.*;

@Entity
public class Ksiazka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tytul;
    private int rokWydania;
    private String isbn;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Ksiazka() {}

    public Ksiazka(String tytul, int rokWydania, String isbn) {
        this.tytul = tytul;
        this.rokWydania = rokWydania;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    // {"autor": {"id": 1}}
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}