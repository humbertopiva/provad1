package br.usjt.ads20.universidadeapp.model;

/**
 * Nome: Humberto Luiz Piva dos Santos
 * RA: 818234523
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Dados {
    private static ArrayList<Universidade> universidades;

    public static void setUniversidades(ArrayList<Universidade> pUniversidades){
        universidades = pUniversidades;
    }

    public static Universidade[] buscaUniversidades(String chave){
        ArrayList<Universidade> lista = Dados.universidades;
        ArrayList<Universidade> filtro;
        Universidade[] universidades;
        if(chave == null || chave.length() == 0){
            filtro = lista;
        } else {
            filtro = new ArrayList<>();
            for(Universidade universidade : lista){
                String nome = universidade.getNome();
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    filtro.add(universidade);
                }
            }
        }

        universidades = filtro.toArray(new Universidade[0]);
        Arrays.sort(universidades);
        return universidades;
    }
}
