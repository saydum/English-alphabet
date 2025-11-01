package com.englishalphabet;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Letter> letters = new ArrayList<>();
    private SoundPlayer soundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLetters = findViewById(R.id.gridLetters);
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

        for (int i = 0; i < letters.size(); i++) {
            final int index = i;
            ImageButton button = new ImageButton(this);
            button.setImageResource(letters.get(i).getImageResource());
            button.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            button.setScaleType(ImageButton.ScaleType.CENTER_INSIDE);
            button.setAdjustViewBounds(true);
            button.setPadding(6, 6, 6, 6);

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = 0;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            button.setLayoutParams(params);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundPlayer.playSound(MainActivity.this, letters.get(index).getSoundResource());
                    v.animate()
                        .scaleX(1.2f)
                        .scaleY(1.2f)
                        .setDuration(150)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                v.animate()
                                        .scaleX(1f)
                                        .scaleY(1f)
                                        .setDuration(150)
                                        .start();
                            }
                        })
                        .start()
                    ;
                }
            });
            gridLetters.addView(button);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundPlayer.stopSound();
    }
}
