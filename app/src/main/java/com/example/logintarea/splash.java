package com.example.logintarea;

import android.os.Bundle;
import android.os.CountDownTimer;

import android.content.Intent;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splash extends AppCompatActivity {

    private TextView countdownText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        // ENCUENTRO EL TEXTVIEW
        countdownText = findViewById(R.id.tv_countdown);

        // CONFIGURO EL CONTADOR EN 5 SEGUNDOS
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // ACTUALIZAR EL TEXT CADA 1 SEGUNDO
                countdownText.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                // Cuando TERMINE EL CONTADOR INICIE EL MAINACTIVITY
                startActivity(new Intent(splash.this, MainActivity.class));
                finish();
            }
        }.start();
    }
}