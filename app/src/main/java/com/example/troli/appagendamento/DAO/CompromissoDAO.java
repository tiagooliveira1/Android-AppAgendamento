package com.example.troli.appagendamento.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.media.MediaCodecInfo;

import java.util.List;

/**
 * Created by troli on 09/05/2018.
 */

@Dao
public interface CompromissoDAO {

    @Insert
    public long inserir(Compromisso compromisso);

    @Query("SELECT * from Compromisso")
    public List<Compromisso> findAll();

    @Query("SELECT * FROM Compromisso where _id == :id")
    public Compromisso findByID(long id);

    @Delete
    public int excluir(Compromisso compromisso);

    @Update
    public int editar(Compromisso compromisso);
}
