package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    ProgressBar pr1;
    ProgressBar pr2;
    ProgressBar pr3;
    TextView txtpor1;
    TextView txtpor2;
    TextView txtpor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        Intent intent3 = getIntent();
        int [] votos = intent3.getIntArrayExtra("resultados");

        pr1 = findViewById(R.id.pr1);
        pr2 = findViewById(R.id.pr2);
        pr3 = findViewById(R.id.pr3);

        txtpor1 = findViewById(R.id.txtpor1);
        txtpor2 = findViewById(R.id.txtpor2);
        txtpor3 = findViewById(R.id.txtpor3);

        int [] porcen = {0,0,0};

        for (int i = 0; i < 3; i++){
            if(votos[0] == 0){
                for (int j = 0; j < 3; j++){
                    porcen[i] = 0;
                }
                break;
            }
            porcen[i] = (votos[i+1]*100)/votos[0];
        }
        pr1.setMax(100);
        pr1.setProgress(porcen[0]);

        pr2.setMax(100);
        pr2.setProgress(porcen[1]);

        pr3.setMax(100);
        pr3.setProgress(porcen[2]);

        txtpor1.setText(String.valueOf(porcen[0] + "%"));
        txtpor2.setText(String.valueOf(porcen[1] + "%"));
        txtpor3.setText(String.valueOf(porcen[2] + "%"));
    }

    public void regresar (View view){
        Intent intent4 = new Intent(getApplicationContext(), MainActivity.class);
        intent4.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent4, 0);
    }
}