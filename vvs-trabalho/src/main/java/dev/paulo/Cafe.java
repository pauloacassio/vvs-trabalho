package dev.paulo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
/*
 * Classe Café
 */
public class Cafe extends PanacheEntity {
    // nome do cafe
    private String nome;
    // nota do cafe
    private int nota;
    // tipo do cafe
    private String tipo;
    // se é favorito
    private boolean favorito;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    private Cafeteria cafeteria;


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return this.nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    public Object getId() {
        return null;
    }
}
