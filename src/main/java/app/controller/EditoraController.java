package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.entity.Editora;
import app.service.EditoraService;

import java.util.List;

@RestController
@RequestMapping("/api/editoras")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @PostMapping
    public ResponseEntity<Editora> criarEditora(@RequestBody Editora editora) {
        Editora novaEditora = editoraService.criarEditora(editora);
        return new ResponseEntity<>(novaEditora, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Editora>> listarEditoras() {
        List<Editora> editoras = editoraService.listarEditoras();
        return new ResponseEntity<>(editoras, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> obterEditora(@PathVariable Long id) {
        Editora editora = editoraService.obterEditora(id);
        return new ResponseEntity<>(editora, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editora> atualizarEditora(@PathVariable Long id, @RequestBody Editora editora) {
        Editora editoraAtualizada = editoraService.atualizarEditora(id, editora);
        return new ResponseEntity<>(editoraAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEditora(@PathVariable Long id) {
        editoraService.deletarEditora(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
