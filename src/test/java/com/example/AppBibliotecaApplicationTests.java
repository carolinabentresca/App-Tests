package com.example;

import com.example.model.Autor;
import com.example.model.Libro;
import com.example.repository.LibroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppBibliotecaApplicationTests {

    @Autowired
    private LibroRepository repository;

    @Test
    void saveLibro() {
        //Create libro
        Libro libro = new Libro();
        libro.setTitulo("Homero y sus Rosquillas");

        //Create autor
        Autor autor = new Autor();
        autor.setNombre("Homero J Simpsons");

        //Add autor references in the libro
        libro.getAutores().add(autor);
        //Add libro references in the autor
        autor.getLibros().add(libro);

        //Save libro
        repository.save(libro);
    }

}
