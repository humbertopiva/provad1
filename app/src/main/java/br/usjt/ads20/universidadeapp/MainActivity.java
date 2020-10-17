package br.usjt.ads20.universidadeapp;

/**
 * Nome: Humberto Luiz Piva dos Santos
 * RA: 818234523
 */

import androidx.appcompat.app.AppCompatActivity;
import br.usjt.ads20.universidadeapp.model.Dados;
import br.usjt.ads20.universidadeapp.model.Universidade;
import br.usjt.ads20.universidadeapp.model.UniversidadeNetwork;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    private ProgressBar progressBar;
    public static final String NOME = "br.usjt.ads20.appfilmes.nome";
    public static final String UNIVERSIDADES = "br.usjt.ads20.appfilmes.universidades";
    private String url = "http://universities.hipolabs.com/search?name=";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText)findViewById(R.id.busca_fila);
        progressBar = (ProgressBar)findViewById(R.id.progressBarMain);
        context = this;
    }

    public void buscarUniversidades(View view){
        progressBar.setVisibility(View.VISIBLE);
        new JsonUniversidades().execute(url + txtNome.getText().toString());
    }

    private class JsonUniversidades extends AsyncTask<String, Void, ArrayList<Universidade>> {
        @Override
        protected ArrayList<Universidade> doInBackground(String... strings) {
            ArrayList<Universidade> universidades = new ArrayList<>();
            try {
                universidades = UniversidadeNetwork.buscarUniversidades(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return universidades;
        }

        @Override
        protected void onPostExecute(ArrayList<Universidade> universidades) {
            progressBar.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(context, ListarUniversidadesActivity.class);
            String nome = txtNome.getText().toString();
            intent.putExtra(NOME, nome);
            intent.putExtra(UNIVERSIDADES, universidades);
            startActivity(intent);
        }
    }
}

