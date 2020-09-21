package com.example.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnLimpar, btnCalcular, btnProximaTela;
    TextView tvMedia, textView;
    EditText etGrauA, etGrauB, etGrauC;
    Resources res;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Aluno aluno = new Aluno();

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnProximaTela = findViewById(R.id.btnProximaTela);
        tvMedia = findViewById(R.id.tvMedia);
        textView = findViewById(R.id.tvMensagem);
        etGrauA = findViewById(R.id.etGrauA);
        etGrauB = findViewById(R.id.etGrauB);
        etGrauC = findViewById(R.id.etGrauC);
        res = getResources();

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etGrauA.setText("");
                etGrauB.setText("");
                etGrauC.setText("");
                textView.setText("Informe as notas do aluno:");
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double grauA, grauB, grauC, media, aprovado;
                try {
                    aluno.setGrauA(Double.parseDouble(etGrauA.getText().toString()));
                    aluno.setGrauB(Double.parseDouble(etGrauB.getText().toString()));
                    aluno.setMedia((aluno.getGrauA() + aluno.getGrauB()) / 2);
                    if (aluno.getMedia() >= 7) {
                        tvMedia.setText("Aprovado! | Nota final: " + aluno.getMedia());
                        aluno.setAprovado(true);
                    } else
                            tvMedia.setText("Recuperação! | Nota parcial: " + aluno.getMedia());
                            try {
                                aluno.setGrauC(Double.parseDouble(etGrauC.getText().toString()));
                            aluno.setMedia( (aluno.getGrauA() + aluno.getGrauB() + aluno.getGrauC()) / 3);
                            if (aluno.getGrauC() >= 5 && aluno.getMedia() >= 5) {
                                tvMedia.setText("Aprovado! | Nota final: " + aluno.getMedia());
                                aluno.setAprovado(true);
                            } else
                                tvMedia.setText("Reprovado! | Nota final: " + aluno.getMedia());
                        } catch (NumberFormatException e){
                                textView.setText("Informe a nota de GC");
                        }
                 } catch (Exception ab){
                            textView.setText("Você precisa inforar as notas de GA e GB!");
                }
            }
        });
        btnProximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent enviaDados = new Intent(MainActivity.this, Lista_de_Alunos.class);
                String dados = "Grau A:"+aluno.getGrauA() +"|"+
                "Grau B:"+aluno.getGrauB() +"|"+
                "Grau C:"+aluno.getGrauC() +"|"+
                "Média :"+aluno.getMedia() +"|"+
                "Aprovado : "+aluno.getAprovado() +"|";
                Bundle bundle = new Bundle();
                bundle.putString("dados", dados);
                enviaDados.putExtras(bundle);
                startActivity(enviaDados);

            }
        });
    }
}