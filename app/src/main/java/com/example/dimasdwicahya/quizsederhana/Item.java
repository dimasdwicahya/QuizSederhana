package com.example.dimasdwicahya.quizsederhana;

public class Item {
    private String soal, jawaban;

    public Item(String soal, String jawaban) {
        this.soal = soal;
        this.jawaban = jawaban;
    }

    public String getSoal() {
        return soal;
    }

    public String getJawaban() {
        return jawaban;
    }

}
