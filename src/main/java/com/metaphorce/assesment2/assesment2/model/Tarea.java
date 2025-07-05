package com.metaphorce.assesment2.assesment2.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private boolean completado;

    public Tarea(int id, String titulo, boolean completado) {
        this.id = id;
        this.titulo = titulo;
        this.completado = completado;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
