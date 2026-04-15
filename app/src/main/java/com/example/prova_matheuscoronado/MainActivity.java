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

        Button btnSalvar = findViewById(R.id.buttonSave);
        btnSalvar.setOnClickListener(v -> {
            String nome = editNome.getText().toString();
            String codigo = editCodigo.getText().toString();
            String precoStr = editPreco.getText().toString();
            String qtdStr = editQtd.getText().toString();

            // Validação de campos obrigatórios
            if (nome.isEmpty() || codigo.isEmpty() || precoStr.isEmpty() || qtdStr.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double preco = Double.parseDouble(precoStr);
                int qtd = Integer.parseInt(qtdStr);

                if (preco > 0 && qtd > 0) {
                    Product p = new Product(nome, codigo, preco, qtd);
                    produtoDao.inserir(p);
                    Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show();
                    limparCampos();
                } else {
                    Toast.makeText(this, "Insira valores maiores que zero!", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Erro: Verifique os campos numéricos!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}