package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.entity.Biblioteca;
import app.service.BibliotecaService;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecas")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping
    public ResponseEntity<Biblioteca> criarBiblioteca(@RequestBody Biblioteca biblioteca) {
        Biblioteca novaBiblioteca = bibliotecaService.criarBiblioteca(biblioteca);
        return new ResponseEntity<>(novaBiblioteca, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Biblioteca>> listarBibliotecas() {
        List<Biblioteca> bibliotecas = bibliotecaService.listarBibliotecas();
        return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> obterBiblioteca(@PathVariable Long id) {
        Biblioteca biblioteca = bibliotecaService.obterBiblioteca(id);
        return new ResponseEntity<>(biblioteca, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Biblioteca> atualizarBiblioteca(@PathVariable Long id, @RequestBody Biblioteca biblioteca) {
        Biblioteca bibliotecaAtualizada = bibliotecaService.atualizarBiblioteca(id, biblioteca);
        return new ResponseEntity<>(bibliotecaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBiblioteca(@PathVariable Long id) {
        bibliotecaService.deletarBiblioteca(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
