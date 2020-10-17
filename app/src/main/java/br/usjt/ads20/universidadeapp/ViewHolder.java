package br.usjt.ads20.universidadeapp;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private ImageView imagemUniversidade;
    private TextView nomeUniversidade, pais, url;

    public ViewHolder(ImageView imagemUniversidade, TextView nomeUniversidade, TextView pais, TextView url) {
        this.imagemUniversidade = imagemUniversidade;
        this.nomeUniversidade = nomeUniversidade;
        this.pais = pais;
        this.url = url;
    }

    public ImageView getImagemUniversidade() {
        return imagemUniversidade;
    }

    public void setImagemUniversidade(ImageView imagemUniversidade) {
        this.imagemUniversidade = imagemUniversidade;
    }

    public TextView getNomeUniversidade() {
        return nomeUniversidade;
    }

    public void setNomeUniversidade(TextView nomeUniversidade) {
        this.nomeUniversidade = nomeUniversidade;
    }

    public TextView getPais() {
        return pais;
    }

    public void setPais(TextView pais) {
        this.pais = pais;
    }

    public TextView getUrl() {
        return url;
    }

    public void setUrl(TextView url) {
        this.url = url;
    }
}
