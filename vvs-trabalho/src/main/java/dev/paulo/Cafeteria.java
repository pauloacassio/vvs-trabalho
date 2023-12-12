package dev.paulo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
/*
 * Classe Cafeteria
 */
public class Cafeteria extends PanacheEntity {
    // nome da cafeteria
    private String nome;
    // endereço da cafeteria
    private String endereco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cafeteria_id")
    @JsonBackReference
    // Método para listar todos cafés relacionados à cafeteria
    private List<Cafe> cafes;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Cafe> getCafes() {
        return cafes;
    }

    public void setCafes(List<Cafe> cafes) {
        this.cafes = cafes;
    }
    // Método para adicionar um café à cafeteria
    public void addCafe(Cafe cafe) {
        this.cafes.add(cafe);
    }
}