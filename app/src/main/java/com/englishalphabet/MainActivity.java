package com.englishalphabet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private int currentIndex = 0;

    private final  ArrayList<Letter> letters = new ArrayList<>();

    private SoundPlayer soundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageViewPng);
        Button btnLeft = findViewById(R.id.btnLeft);
        Button btnRight = findViewById(R.id.btnRight);
        Button btnPlaySound = findViewById(R.id.btnPlaySound);

        soundPlayer = new SoundPlayer();

        letters.add(new Letter(R.drawable.a, R.raw.a));
        letters.add(new Letter(R.drawable.b, R.raw.b));
        letters.add(new Letter(R.drawable.c, R.raw.c));
        letters.add(new Letter(R.drawable.d, R.raw.d));
        letters.add(new Letter(R.drawable.e, R.raw.e));
        letters.add(new Letter(R.drawable.f, R.raw.f));
        letters.add(new Letter(R.drawable.g, R.raw.g));
        letters.add(new Letter(R.drawable.h, R.raw.h));
        letters.add(new Letter(R.drawable.i, R.raw.i));
        letters.add(new Letter(R.drawable.j, R.raw.j));
        letters.add(new Letter(R.drawable.k, R.raw.k));
        letters.add(new Letter(R.drawable.l, R.raw.l));
        letters.add(new Letter(R.drawable.m, R.raw.m));
        letters.add(new Letter(R.drawable.n, R.raw.n));
        letters.add(new Letter(R.drawable.o, R.raw.o));
        letters.add(new Letter(R.drawable.p, R.raw.p));
        letters.add(new Letter(R.drawable.q, R.raw.q));
        letters.add(new Letter(R.drawable.r, R.raw.r));
        letters.add(new Letter(R.drawable.s, R.raw.s));
        letters.add(new Letter(R.drawable.t, R.raw.t));
        letters.add(new Letter(R.drawable.u, R.raw.u));
        letters.add(new Letter(R.drawable.v, R.raw.v));
        letters.add(new Letter(R.drawable.w, R.raw.w));
        letters.add(new Letter(R.drawable.x, R.raw.x));
        letters.add(new Letter(R.drawable.y, R.raw.y));
        letters.add(new Letter(R.drawable.z, R.raw.z));

        imageView.setImageResource(letters.get(currentIndex).getImageResource());

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    currentIndex = letters.size() - 1;
                }
                updateImage();
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex < letters.size() - 1) {
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }
                updateImage();
            }
        });

        btnPlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
            }
        });
    }

    private void updateImage() { imageView.setImageResource(letters.get(currentIndex).getImageResource()); }

    private void playSound() { soundPlayer.playSound(this, letters.get(currentIndex).getSoundResource()); }

    @Override
    protected void onStop() {
        super.onStop();
        soundPlayer.stopSound();
    }
}