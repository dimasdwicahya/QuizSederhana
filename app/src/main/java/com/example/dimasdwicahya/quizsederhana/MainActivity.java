package com.example.dimasdwicahya.quizsederhana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    TextView soalnya;
    Button bT, bF;

    Soal nSoal;
    int questionLength;

    ArrayList<Item> questionList;

    int currentQuestion =0;

    boolean winner = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soalnya = (TextView) findViewById(R.id.tvSoal);
        bT = (Button) findViewById(R.id.btTrue);
        bF = (Button) findViewById(R.id.btFalse);

        nSoal = new Soal();
        questionLength = nSoal.nSoal.length;

        questionList = new ArrayList<>();

        for (int i = 0; i < questionLength; i++) {
            questionList.add(new Item(nSoal.getSoal(i), nSoal.getJawaban(i)));
        }

        //acak soal
        Collections.shuffle(questionList);

        //mulai soal
        setSoal(currentQuestion);


        bT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cekJawaban(currentQuestion)) {
                    //benar
                    currentQuestion++;
                    if (currentQuestion < questionLength) {
                        setSoal(currentQuestion);
                    } else {
                        winner = true;
                        selesai();
                    }
                } else {
                    //salah
                    selesai();
                }

            }
        });

        bF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cekJawaban(currentQuestion)) {
                    //benar
                    currentQuestion++;
                    if (currentQuestion < questionLength) {
                        setSoal(currentQuestion);
                    } else {
                        winner = true;
                        selesai();
                    }
                } else {
                    //salah
                    selesai();
                }

            }
        });

    }
        private void setSoal(int number){
            soalnya.setText(questionList.get(number).getSoal());
        };

        private boolean cekJawaban(int number){
            String jawab = questionList.get(number).getJawaban();
            return jawab.equals("true");
        }

        //game over
    private void selesai(){
            if(winner){
                Toast.makeText(this, "Bener bre", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Salah bre", Toast.LENGTH_LONG).show();
                finish();
            }
    }


}
