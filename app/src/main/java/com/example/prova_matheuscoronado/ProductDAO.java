package com.example.prova_matheuscoronado;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface ProductDAO {
    // Método para inserir um novo produto no estoque
    @Insert
    void inserir(Product produto);
}