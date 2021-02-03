package com.company;

public class Dolgozo {
    private String nev;
    private String nem;
    private int kor;
    private int fizetes;

    public Dolgozo(String nev, String nem, int kor, int fizetes) {
        this.nev = nev;
        this.nem = nem;
        this.kor = kor;
        this.fizetes = fizetes;
    }

    public String getNev() {
        return nev;
    }

    public String getNem() {
        return nem;
    }

    public int getKor() {
        return kor;
    }

    public int getFizetes() {
        return fizetes;
    }

    @Override
    public String toString() {
        return "Dolgozo{" +
                "nev='" + nev + '\'' +
                ", nem='" + nem + '\'' +
                ", kor=" + kor +
                ", fizetes=" + fizetes +
                '}';
    }
}
