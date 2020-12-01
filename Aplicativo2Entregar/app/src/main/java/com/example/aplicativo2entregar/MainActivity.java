package com.example.aplicativo2entregar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editNomeAluno, editPrimNota, editSegNota, editFreq;
    Button btnValida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNomeAluno = findViewById(R.id.editNomeAluno);
        editPrimNota = findViewById(R.id.editPrimNota);
        editSegNota = findViewById(R.id.editSegNota);
        editFreq = findViewById(R.id.editFreq);

        btnValida = findViewById(R.id.button);
    }

    public void resultadoAluno(View view) {

//        System.out.println("noda 1: " + notaDbpri + " nota 2: " + notaDbseg + " freq: " + freqDb);

        if(editNomeAluno.length() == 0){
            Toast.makeText(getApplicationContext(), "Digite o nome do Aluno",Toast.LENGTH_SHORT).show();
        }else if (editPrimNota.length() == 0){
            Toast.makeText(getApplicationContext(), "Digite a primeira nota",Toast.LENGTH_SHORT).show();
        } else if (editSegNota.length() == 0){
            Toast.makeText(getApplicationContext(), "Digite a segunda nota",Toast.LENGTH_SHORT).show();
        } else if (editFreq.length() == 0) {
            Toast.makeText(getApplicationContext(), "Digite a frequencia nas aulas", Toast.LENGTH_SHORT).show();
        } else if (Double.parseDouble(editPrimNota.getText().toString()) > 10 || Double.parseDouble(editPrimNota.getText().toString()) < 0) {
            Toast.makeText(getApplicationContext(), "Digite a primeira nota de 0 a 10, possivel colocar com .", Toast.LENGTH_SHORT).show();
            editPrimNota.getText().clear();
        } else  if (Double.parseDouble(editSegNota.getText().toString()) > 10 || Double.parseDouble(editSegNota.getText().toString()) < 0) {
            Toast.makeText(getApplicationContext(), "Digite a segunda nota de 0 a 10, possivel colocar com .",  Toast.LENGTH_SHORT).show();
            editSegNota.getText().clear();
        } else  if (Integer.parseInt(editFreq.getText().toString()) > 100 || Integer.parseInt(editFreq.getText().toString()) < 0) {
            Toast.makeText(getApplicationContext(), "Digite a frequencia de 0 a 100",
                    Toast.LENGTH_SHORT).show();
            editFreq.getText().clear();
        } else {
            String nomeAluno = editNomeAluno.getText().toString();
            Double notaDbpri = Double.parseDouble(editPrimNota.getText().toString());
            Double notaDbseg = Double.parseDouble(editSegNota.getText().toString());
            Integer freqDb = Integer.parseInt(editFreq.getText().toString());

            Double media = 0.0;
            media = notaDbpri + notaDbseg;
            media = media / 2;

            if (notaDbpri > 10 || notaDbseg > 10) {
                Toast.makeText(getApplicationContext(), "Digite a nota entre 0 a 10 podendo ter .", Toast.LENGTH_SHORT).show();
            } else {
//            System.out.println("media: " + media);

                Intent it = new Intent(this, Resultado.class);
                Bundle params = new Bundle();
                params.putString("nomeAluno", nomeAluno);
                params.putInt("freqDb", freqDb);
                params.putDouble("media", media);
                it.putExtras(params);
                startActivity(it);
            }
        }
    }
}