package com.example.sergionotaslista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    baseDeDatos myDB;
    Button btnAñadir,btnLista;
    EditText notaEntrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notaEntrada = (EditText) findViewById(R.id.notaEntrada);
        btnAñadir = (Button) findViewById(R.id.btnAñadir);
        btnLista = (Button) findViewById(R.id.btnLista);
        myDB = new baseDeDatos(this);

        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = notaEntrada.getText().toString();
                if(notaEntrada.length()!= 0){
                    AñadirDatos(newEntry);
                    notaEntrada.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "DEBES PONER ALGO EN EL TEXTO!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VerContenidos.class);
                startActivity(intent);
            }
        });
    }

    public void AñadirDatos(String newEntry) {
        boolean insertarDatos = myDB.añadirDatos(newEntry);

        if(insertarDatos==true){
            Toast.makeText(this, "DATO INGRESADO!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "ALGO FALLÓ :(.", Toast.LENGTH_LONG).show();
        }
    }
}