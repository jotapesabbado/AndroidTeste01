package com.example.joo.androidteste01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/*PENSAR EM COMO RESOLVER O PROBLEMA DO FAVORITO...
* TALVEZ CRIANDO UM METODOS ON CLIC NA PROPRIA CHECK BOX
* TALVEZ NEM PRECISE MANDAR O FAVORITO ATRAVEZ DAS LINHAS DO CRIAÇÃO DE OBJETO...
* */




public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    //TESTES
    TextView teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BOTÃO FILTRO
        Button btnfilter = (Button)findViewById(R.id.button2);

        //LISTA
        ListView lista = (ListView)findViewById(R.id.lista);
        Log.d(TAG,"onCreate: Started.");



        //LISTA

    /*Criar OBJETOS Empresas */
        Empresas exemplo1 = new Empresas("CLIC CAMAQUÂ","08:00 AS 20:00",true);
        Empresas exemplo2 = new Empresas("CLIC CAMAQUÂ","08:00 AS 20:00",true);
        Empresas exemplo3 = new Empresas("CLIC CAMAQUÂ","08:00 AS 20:00",false);
        Empresas exemplo4 = new Empresas("CLIC CAMAQUÂ","08:00 AS 20:00",true);
        Empresas exemplo5 = new Empresas("CLIC CAMAQUÂ","08:00 AS 20:00",false);


    /*ADD Empresas no vetor*/
       ArrayList<Empresas> listaEmpresas = new ArrayList<>();
        listaEmpresas.add(exemplo1);
        listaEmpresas.add(exemplo2);
        listaEmpresas.add(exemplo3);
        listaEmpresas.add(exemplo4);
        listaEmpresas.add(exemplo5);

    /*Adaptador de lista, para que mostre na forma do layout criado*/
        EmpresaListAdapter adapter = new EmpresaListAdapter(this, R.layout.list_layout, listaEmpresas);
        lista.setAdapter(adapter);

    }

    //FILTRO
    public void FilterOption(View view) {
        AlertDialog alerta;
        CharSequence[] charSequences = new CharSequence[]{"Todos", "Favoritos","Recomendados"};
        final boolean[] checados = new boolean[charSequences.length];

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("O que você gosta?");
        builder.setMultiChoiceItems(charSequences, checados, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface arg0, int arg1, boolean arg2) {
                checados[arg1] = arg2;
            }
        });

        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                StringBuilder texto = new StringBuilder("Checados: ");
                for (boolean ch : checados) {
                    texto.append(ch).append("; ");
                }
                //Toast.makeText(MainActivity.this, texto.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        alerta = builder.create();
        alerta.show();

    }


    //TESTE DO CLICK_LAYOUT
    public void Teste(View view) {
        setContentView(R.layout.click_layout);

    }
}



