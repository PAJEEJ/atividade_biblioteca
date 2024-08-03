package app.service;

import org.springframework.stereotype.Service;
import app.entity.Editora;

import java.util.ArrayList;
import java.util.List;

@Service
public class EditoraService {

    private List<Editora> editoras = new ArrayList<>();

    public Editora criarEditora(Editora editora) {
        editora.setId((long) (editoras.size() + 1));
        editoras.add(editora);
        return editora;
    }

    public List<Editora> listarEditoras() {
        return editoras;
    }

    public Editora obterEditora(Long id) {
        return editoras.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public Editora atualizarEditora(Long id, Editora editora) {
        Editora editoraExistente = this.obterEditora(id);
        if (editoraExistente != null) {
            editoraExistente.setNome(editora.getNome());
            editoraExistente.setEndereco(editora.getEndereco());
        }
        return editoraExistente;
    }

    public void deletarEditora(Long id) {
        editoras.removeIf(e -> e.getId().equals(id));
    }
}
