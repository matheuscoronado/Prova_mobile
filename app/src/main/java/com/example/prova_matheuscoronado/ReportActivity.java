package com.example.prova_matheuscoronado;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class ReportActivity extends AppCompatActivity {
    private TextView textViewRelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        textViewRelatorio = findViewById(R.id.textViewReport);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(v -> voltarParaCadastro());
    }

    // Acessa o banco de dados de produtos
    ProductDatabase db = ProductDatabase.getInstance(this);
    ProductDAO produtoDao = db.productDao();

    // Recupera a lista de produtos cadastrados
    List<Product> listaProdutos = produtoDao.listarTodos();

    public void voltarParaCadastro() {
        startActivity(new Intent(ReportActivity.this, MainActivity.class));
        finish();
    }

    private void gerarRelatorioEstoque(List<Product> lista) {
        StringBuilder relatorio = new StringBuilder();

        for (Product p : lista) {
            relatorio.append("Produto: ").append(p.getNome()).append("\n")
                    .append("Código: ").append(p.getCodigo()).append("\n")
                    .append("Preço: R$ ").append(String.format("%.2f", p.getPreco())).append("\n")
                    .append("----------------------------\n\n");
        }

        mostrarResultado(relatorio.toString(), lista.isEmpty());
    }
}