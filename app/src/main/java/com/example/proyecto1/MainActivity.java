package com.example.proyecto1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Estudiante> votantes = new ArrayList<Estudiante>();
    int n = 0;
    int posicion = 0;
    int voto = 0;

   private ArrayList<Estudiante> GetData(){
       votantes.add(new Estudiante("8-944-327",0));
       votantes.add(new Estudiante("3-740-1394",0));
       votantes.add(new Estudiante("20-53-4282",0));
       votantes.add(new Estudiante("8-943-1867",0));
       votantes.add(new Estudiante("8-937-503",0));
       votantes.add(new Estudiante("8-952-2444",0));
       votantes.add(new Estudiante("8-943-12",0));
       votantes.add(new Estudiante("8-986-549",0));
       votantes.add(new Estudiante("8-957-1827",0));
       votantes.add(new Estudiante("8-940-1311",0));
       votantes.add(new Estudiante("8-863-1620",0));
       votantes.add(new Estudiante("8-964-691",0));
       votantes.add(new Estudiante("8-954-1126",0));
       votantes.add(new Estudiante("8-1039-1537",0));
       votantes.add(new Estudiante("8-925-1168",0));
       votantes.add(new Estudiante("8-940-1505",0));
       votantes.add(new Estudiante("8-938-925",0));
       votantes.add(new Estudiante("3-743-2493",0));
       votantes.add(new Estudiante("E-8-169755",0));
       votantes.add(new Estudiante("8-971-1811",0));
       votantes.add(new Estudiante("8-940-408",0));
       votantes.add(new Estudiante("8-937-1640",0));
       votantes.add(new Estudiante("8-939-1578",0));
       votantes.add(new Estudiante("8-942-1406",0));
       votantes.add(new Estudiante("6-722-724",0));
       votantes.add(new Estudiante("8-941-1215",0));
       votantes.add(new Estudiante("8-962-1218",0));
       votantes.add(new Estudiante("8-941-924",0));
       votantes.add(new Estudiante("8-980-2414",0));
       votantes.add(new Estudiante("3-742-2055",0));
       votantes.add(new Estudiante("8-942-1192",0));
       votantes.add(new Estudiante("8-904-1189",0));
       votantes.add(new Estudiante("8-959-857",0));
       votantes.add(new Estudiante("8-964-1554",0));
       votantes.add(new Estudiante("8-1066-1018",0));
       votantes.add(new Estudiante("8-1055-701",0));
       votantes.add(new Estudiante("8-970-242",0));
       votantes.add(new Estudiante("3-752-1461",0));
       votantes.add(new Estudiante("3-745-950",0));
       votantes.add(new Estudiante("3-743-1190",0));
       return votantes;
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent2 = getIntent();
        n = intent2.getIntExtra("n",0);

        int a= voto;

        if (n == 0)
            GetData();
        else votantes = (ArrayList<Estudiante>) getIntent().getSerializableExtra("listaAct");

    }

    public void ingresar (View view){
       n = 1;
       boolean match = false;
       String cedula;
       EditText edtCed = findViewById(R.id.edtCed);
       cedula = edtCed.getText().toString();

        Intent intent = new Intent(MainActivity.this,Candidatos.class);

       for(int i = 0; i < votantes.size(); i++){
           if(cedula.equals(votantes.get(i).cedula)){
               if(votantes.get(i).voto == 0 ){
                   intent.putExtra("posicion", i);

                   intent.putExtra("lista", votantes);
                   startActivity(intent);
                   match = true;
                   break;
               }
               else {
                   AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                   alertDialogBuilder.setTitle("Denegado");
                   alertDialogBuilder
                           .setMessage("Usted ya ha votado")
                           .setCancelable(false)
                           .setPositiveButton("Aceptar",new DialogInterface.OnClickListener()
                           {
                               public void onClick(DialogInterface dialog,int id) {
                                   dialog.cancel();
                               }
                           }).create().show();
                   match = true;
                   break;
               }
           }
       }
        if(!match){
            AlertDialog.Builder alertnotfound = new AlertDialog.Builder(this);
            alertnotfound.setTitle("Denegado");
            alertnotfound
                    .setMessage("Esta cédula no está registrada")
                    .setCancelable(false)
                    .setPositiveButton("Aceptar",new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    }).create().show();
        }
    }


    public void resultados (View view){
        int[] votos = {0,0,0,0,0};
        Intent intent3 = new Intent(MainActivity.this,Resultados.class);
        for(int i = 0; i < votantes.size(); i++){
            if (votantes.get(i).voto != 0){
                if (votantes.get(i).voto == 1){
                    votos[1]++;
                }
                else if (votantes.get(i).voto == 2){
                    votos[2]++;
                }
                else if (votantes.get(i).voto == 3){
                    votos[3]++;
                }
                else votos[4]++;
                votos[0]++;
            }
        }
        intent3.putExtra("resultados",votos);
        startActivity(intent3);
        }
}