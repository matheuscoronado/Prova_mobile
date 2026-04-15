package com.example.prova_matheuscoronado;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ProductDAO {
    // Método para inserir um novo produto no estoque
    @Insert
    void inserir(Product produto);

    // Busca todos os produtos na tabela 'produtos' definida na Entidade
    @Query("SELECT * FROM produtos")
    List<Product> listarTodos();
}