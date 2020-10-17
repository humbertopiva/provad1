package br.usjt.ads20.universidadeapp;

/**
 * Nome: Humberto Luiz Piva dos Santos
 * RA: 818234523
 */

import androidx.appcompat.app.AppCompatActivity;
import br.usjt.ads20.universidadeapp.model.Dados;
import br.usjt.ads20.universidadeapp.model.Universidade;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarUniversidadesActivity extends AppCompatActivity {
    public static final String UNIVERSIDADE = "br.usjt.ads20.appfilmes.universidade";
    Universidade[] lista;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_universidades);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);

        ArrayList<Universidade> universidades = (ArrayList<Universidade>) intent.getSerializableExtra(MainActivity.UNIVERSIDADES);
        Dados.setUniversidades(universidades);
        lista = Dados.buscaUniversidades(chave);
        BaseAdapter adapter = new UniversidadeAdapter(this, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Uri uri = Uri.parse(lista[position].getWebPages());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                startActivity(intent);
            }

        });

    }

}