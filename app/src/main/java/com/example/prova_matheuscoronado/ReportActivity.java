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

    public void voltarParaCadastro() {
        startActivity(new Intent(ReportActivity.this, MainActivity.class));
        finish();
    }
}