package com.example.timer;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textViewCzas;
    Button buttonStart, buttonStop, buttonReset;
    int ileSekund = 0;
    boolean czyLiczy = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textViewCzas = findViewById(R.id.textViewCzas);
        buttonStart = findViewById(R.id.button);
        buttonStop = findViewById(R.id.button2);
        buttonReset = findViewById(R.id.button3);

        Handler handler = new Handler();
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        if(czyLiczy){
                            ileSekund++;
//                            textViewCzas.setText(""+ileSekund);
                            wyswietlCzas(ileSekund);
                        }
                        handler.postDelayed(this, 1000);
                    }
                }
        );
        buttonStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyLiczy = true;
                    }
                }
        );
        buttonStop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyLiczy = false;
                    }
                }
        );
        buttonReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ileSekund = 0;
                    }
                }
        );
    }
    private void wyswietlCzas(int ile){
        int sekundy = ile%60;
        int godziny = ile/3600;
        int minuty = (ile/60)%60;
        textViewCzas.setText(String.format("%02d:%02d:%02d", godziny, minuty, sekundy));
    }
}