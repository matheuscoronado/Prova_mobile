package com.example.prova_matheuscoronado;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Declaração dos campos de entrada e do DAO
    private EditText editNome, editCodigo, editPreco, editQtd;
    private ProductDAO produtoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mapeamento dos componentes do XML
        editNome = findViewById(R.id.editTextProductName);
        editCodigo = findViewById(R.id.editTextProductCode);
        editPreco = findViewById(R.id.editTextProductPrice);
        editQtd = findViewById(R.id.editTextProductQuantity);

        // Inicialização do Banco de Dados Room
        ProductDatabase db = ProductDatabase.getInstance(this);
        produtoDao = db.productDao();
    }
}