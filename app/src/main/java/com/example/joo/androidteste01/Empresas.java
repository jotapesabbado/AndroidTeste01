package com.example.joo.androidteste01;

/**
 * Created by João on 19/06/2018.
 */



/*
TO DO:
-LEMBRAR DE DESCOMENTAR METODOS DA URL*/
public class Empresas {
    private String nome;
    private String horario;
    private boolean favorito;
    //private String url;


    public Empresas(String nome, String horario, boolean favorito/*, String url*/) {
        this.nome = nome;
        this.horario = horario;
        this.favorito = favorito;
        //this.url = url;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
/*
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    */
}
