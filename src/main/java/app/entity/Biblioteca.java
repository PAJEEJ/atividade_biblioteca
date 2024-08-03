package app.entity;

public class Biblioteca {

    private Long id;
    private String endereco;
    private String telefone;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public Biblioteca(Long id, String endereco, String telefone) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
