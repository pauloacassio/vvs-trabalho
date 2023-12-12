package dev.paulo;

import java.util.ArrayList;
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
    private String nome;// nome da cafeteria
    private String endereco;// endereço da cafeteria

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cafeteria_id")
    @JsonBackReference
    // Lista de cafés
    private List<Cafe> cafes;

    // Construtor para iniciar lista de cafes
    public Cafeteria() {
        this.cafes = new ArrayList<>();
    }

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