package com.example.aplicativo2entregar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView mostrarNome = findViewById(R.id.mostrarNomeAluno);
        TextView mostrarMedia = findViewById(R.id.mostrarMedia);

        Intent it = getIntent();
        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){
                String nomeAluno = params.getString("nomeAluno");
                mostrarNome.setText(nomeAluno);
                mostrarMedia.setText(status(params.getDouble("media"), params.getInt("freqDb")));
            }
        }
    }

    public String status(Double media, Integer freqDb){
        String msg;

        if (freqDb < 75){
            msg = "Reprovado por falta, sua frequencia foi " + freqDb + " de 100.";
        }else if (media < 4){
            msg = "Reprovado por nota, sua nota foi: " + media;
        }else if (media >= 4.0 && media < 7.0) {
            msg = "Fazer FINAL, com a media: " + media;
        }else {
            msg = "Parabéns, foi APROVADO, com a nota: " + media;
        }
        return msg;
    }
}