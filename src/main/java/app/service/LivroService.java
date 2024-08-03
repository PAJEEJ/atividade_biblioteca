package app.service;

import org.springframework.stereotype.Service;
import app.entity.Livro;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private List<Livro> livros = new ArrayList<>();

    public Livro criarLivro(Livro livro) {
        livro.setId((long) (livros.size() + 1));
        livros.add(livro);
        return livro;
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public Livro obterLivro(Long id) {
        return livros.stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
    }

    public Livro atualizarLivro(Long id, Livro livro) {
        Livro livroExistente = this.obterLivro(id);
        if (livroExistente != null) {
            livroExistente.setTitulo(livro.getTitulo());
            livroExistente.setAnoDePublicacao(livro.getAnoDePublicacao());
            livroExistente.setAutor(livro.getAutor());
            livroExistente.setEditora(livro.getEditora());
        }
        return livroExistente;
    }

    public void deletarLivro(Long id) {
        livros.removeIf(l -> l.getId().equals(id));
    }
}
