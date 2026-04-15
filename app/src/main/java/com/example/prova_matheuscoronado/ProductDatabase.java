package com.example.prova_matheuscoronado;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// Definimos a entidade Product e a versão do banco
@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {

    // Método abstrato para acessar o DAO de produtos
    public abstract ProductDAO productDao();

    // Instância única para o padrão Singleton
    private static ProductDatabase instancia;

}