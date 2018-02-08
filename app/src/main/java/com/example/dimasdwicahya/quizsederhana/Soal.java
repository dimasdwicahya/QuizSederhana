package com.example.dimasdwicahya.quizsederhana;

/**
 * Created by asus a456 on 06/02/2018.
 */

public class Soal {
    public String nSoal[] ={
            "Apakah tel-u PTN?",
            "Apakah tel-u di Bandung?",
            "Apakah tel-u panas?"

    };

    public String nJawaban[] ={
            "false","false","true"
    };

    public String getSoal(int number){
        return nSoal[number];
    }

    public String getJawaban(int number){
        return nJawaban[number];
    }
}
