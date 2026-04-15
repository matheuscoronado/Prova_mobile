package com.example.prova_matheuscoronado;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editNome, editCodigo, editPreco, editQtd;
    private ProductDAO produtoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialização
        editNome = findViewById(R.id.editTextProductName);
        editCodigo = findViewById(R.id.editTextProductCode);
        editPreco = findViewById(R.id.editTextProductPrice);
        editQtd = findViewById(R.id.editTextProductQuantity);

        Button btnSalvar = findViewById(R.id.buttonSave);
        Button btnRelatorio = findViewById(R.id.buttonReport);

        ProductDatabase db = ProductDatabase.getInstance(this);
        produtoDao = db.productDao();

        btnSalvar.setOnClickListener(v -> salvar());

        btnRelatorio.setOnClickListener(v ->
                startActivity(new Intent(this, ReportActivity.class))
        );
    }

    private void salvar() {
        String nome = editNome.getText().toString();
        String codigo = editCodigo.getText().toString();
        String precoStr = editPreco.getText().toString();
        String qtdStr = editQtd.getText().toString();

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
                Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_SHORT).show();
                limpar();
            } else {
                Toast.makeText(this, "Preço e Qtd devem ser positivos!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Erro nos dados numéricos!", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpar() {
        editNome.setText(""); editCodigo.setText(""); editPreco.setText(""); editQtd.setText("");
    }
}