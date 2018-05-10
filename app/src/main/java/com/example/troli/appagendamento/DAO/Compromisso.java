package com.example.troli.appagendamento.DAO;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by troli on 09/05/2018.
 */

@Entity
public class Compromisso {

    @PrimaryKey(autoGenerate = true)
    private int _id;
    private String titulo;
    private String descricao;
    private int prioridade;

    public Compromisso() {

    }


    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    private long data;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }



}
