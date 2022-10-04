package com.example.proyecto1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;

public class Candidatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidatos);
    }

    public void Votar (View view){
        ArrayList<Estudiante> votante2 = new ArrayList<Estudiante>();
        Intent intent = getIntent();
        votante2 = (ArrayList<Estudiante>) getIntent().getSerializableExtra("lista");

        int posicion = intent.getIntExtra("posicion",0);

        int voto = 0;
        int n = 1;

        Intent intent2 = new Intent(getApplicationContext(),MainActivity.class);

        RadioButton rb1 = findViewById(R.id.rb1);
        RadioButton rb2 = findViewById(R.id.rb2);
        RadioButton rb3 = findViewById(R.id.rb3);
        RadioButton rb4 = findViewById(R.id.rb4);

        if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
            if(rb1.isChecked()){
                voto = 1;

            }
            else if (rb2.isChecked()){
                voto = 2;
            }
            else if (rb3.isChecked()){
                voto = 3;
            }
            else voto = 4;

            votante2.get(posicion).voto = voto;

            intent2.putExtra("listaAct", votante2);
            intent2.putExtra("n", n);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Felicidades");
            alertDialogBuilder
                    .setMessage("Su voto ya ha sido procesado")
                    .setCancelable(false)
                    .setPositiveButton("Aceptar",new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                            startActivity(intent2);
                        }
                    }).create().show();

        }
        else {
            AlertDialog.Builder alertvote = new AlertDialog.Builder(this);
            alertvote.setTitle("Advertencia");
            alertvote
                    .setMessage("Debe seleccionar un candidato para votar")
                    .setPositiveButton("Aceptar",new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    }).create().show();
        }
    }
}