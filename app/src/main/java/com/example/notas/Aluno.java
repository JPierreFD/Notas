package com.example.notas;

import java.security.PrivateKey;

public class Aluno {
    private int id;
    private double grauA, grauB, grauC, media;
    private boolean aprovado;

    private Aluno(double grauA, double grauB, double grauC, double media, boolean aprovado) {
        this.grauA = grauA;
        this.grauB = grauB;
        this.grauC = grauC;
        this.media = media;
        this.aprovado = aprovado;
    }

    public Aluno() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrauA() {
        return grauA;
    }

    public void setGrauA(double grauA) {
        this.grauA = grauA;
    }

    public double getGrauB() {
        return grauB;
    }

    public void setGrauB(double grauB) {
        this.grauB = grauB;
    }

    public double getGrauC() {
        return grauC;
    }

    public void setGrauC(double grauC) {
        this.grauC = grauC;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
}
