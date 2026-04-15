package com.example.prova_matheuscoronado;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "produtos")
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String codigo;
    private double preco;
    private int quantidade;

    // Construtor para criar o objeto com os dados obrigatórios
    public Product(String nome, String codigo, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}