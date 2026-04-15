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

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}