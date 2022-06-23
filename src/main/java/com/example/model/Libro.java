package com.example.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "libro")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titulo;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "libro_autor", joinColumns = {
        @JoinColumn(name = "libro_id")}, inverseJoinColumns = {
        @JoinColumn(name = "autor_id")})
    private List<Autor> autores = new ArrayList();

    public Libro() {
    }

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public Libro(int id, String titulo, List<Autor> autores) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

}
