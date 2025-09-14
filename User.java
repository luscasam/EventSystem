package eventsystem;

import java.io.Serializable;

public class User implements Serializable {
    private String nome;
    private String endereco;
    private String categoria;

    public User(String nome, String endereco, String categoria) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
    }

    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return nome + " (" + categoria + ") - " + endereco;
    }
}
