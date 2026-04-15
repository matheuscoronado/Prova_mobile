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

        // Busca dados do banco
        ProductDatabase db = ProductDatabase.getInstance(this);
        ProductDAO produtoDao = db.productDao();
        List<Product> lista = produtoDao.listarTodos();

        gerarRelatorio(lista);
    }

    private void gerarRelatorio(List<Product> lista) {
        if (lista.isEmpty()) {
            textViewRelatorio.setText("Estoque vazio.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Product p : lista) {
            sb.append("Nome: ").append(p.getNome()).append("\n")
                    .append("Código: ").append(p.getCodigo()).append("\n")
                    .append("Preço: R$ ").append(String.format("%.2f", p.getPreco())).append("\n")
                    .append("Qtd: ").append(p.getQuantidade()).append("\n")
                    .append("----------------------------\n\n");
        }
        textViewRelatorio.setText(sb.toString());
    }

    public void voltarParaCadastro() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}