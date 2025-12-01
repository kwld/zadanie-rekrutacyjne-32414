package com.ksiegarnia.app.autor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ksiegarnia.app.ksiazka.Ksiazka;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imie;
    private String nazwisko;
    
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    // Pętla Autor -> Książki -> Autor...
    @JsonIgnore 
    private Set<Ksiazka> ksiazki = new HashSet<>();

    public Autor() {}

    public Autor(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Set<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(Set<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }
}