package com.example.notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Lista_de_Alunos extends AppCompatActivity {

    public EditText etLista;
    Button btnNovoCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de__alunos);

        etLista = (EditText) findViewById(R.id.etLista);
        Intent receberDados = getIntent();
        Bundle bundle = receberDados.getExtras();
        etLista.setText(bundle.getString("dados"));

        btnNovoCadastro = (Button)findViewById(R.id.btnNovoCadastro);
        btnNovoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}