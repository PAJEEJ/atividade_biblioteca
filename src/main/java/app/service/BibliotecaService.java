package app.service;
import app.entity.Biblioteca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BibliotecaService {

    private List<Biblioteca> bibliotecas = new ArrayList<>();

    public Biblioteca criarBiblioteca(Biblioteca biblioteca) {
        biblioteca.setId((long) (bibliotecas.size() + 1));
        bibliotecas.add(biblioteca);
        return biblioteca;
    }

    public List<Biblioteca> listarBibliotecas() {
        return bibliotecas;
    }

    public Biblioteca obterBiblioteca(Long id) {
        return bibliotecas.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    public Biblioteca atualizarBiblioteca(Long id, Biblioteca biblioteca) {
        Biblioteca bibliotecaExistente = this.obterBiblioteca(id);
        if (bibliotecaExistente != null) {
            bibliotecaExistente.setEndereco(biblioteca.getEndereco());
            bibliotecaExistente.setTelefone(biblioteca.getTelefone());
        }
        return bibliotecaExistente;
    }

    public void deletarBiblioteca(Long id) {
        bibliotecas.removeIf(b -> b.getId().equals(id));
    }
}
