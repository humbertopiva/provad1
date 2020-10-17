package br.usjt.ads20.universidadeapp.model;

/**
 * Nome: Humberto Luiz Piva dos Santos
 * RA: 818234523
 */

import java.io.Serializable;

public class Universidade implements Serializable, Comparable<Universidade>{

    private String nome;
    private String pais;
    private String siglaPais;
    private String webPages;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSiglaPais() {
        return siglaPais;
    }

    public void setSiglaPais(String siglaPais) {
        this.siglaPais = siglaPais;
    }

    public String getWebPages() {
        return webPages;
    }

    public void setWebPages(String webPages) {
        this.webPages = webPages;
    }

    @Override
    public int compareTo(Universidade universidade) {
        return getNome().compareTo(universidade.getNome());
    }
}
