package br.usjt.ads20.universidadeapp.model;

/**
 * Nome: Humberto Luiz Piva dos Santos
 * RA: 818234523
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UniversidadeNetwork {

    public static ArrayList<Universidade> buscarUniversidades(String url) throws IOException {

        ArrayList<Universidade> universidades = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();


        try {

            JSONArray lista = new JSONArray(json);

            for(int i = 0; i < lista.length(); i++){
                Universidade universidade = new Universidade();
                JSONObject item = (JSONObject) lista.get(i);

                universidade.setNome(item.getString("name"));
                universidade.setPais(item.getString("country"));
                universidade.setSiglaPais(item.getString("alpha_two_code"));

                JSONArray pages = item.getJSONArray("web_pages");

                universidade.setWebPages(pages.getString(0));

                universidades.add(universidade);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return universidades;
    }

}
