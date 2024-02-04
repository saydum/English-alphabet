package com.englishalphabet;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private int currentIndex = 0;
//    private Button playButton;

    private final ArrayList<Integer> imageResource = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageViewPng);
        Button btnLeft = findViewById(R.id.btnLeft);
        Button btnRight = findViewById(R.id.btnRight);

        imageResource.add(R.drawable.a);
        imageResource.add(R.drawable.b);
        imageResource.add(R.drawable.c);
        imageResource.add(R.drawable.d);
        imageResource.add(R.drawable.e);
        imageResource.add(R.drawable.f);
        imageResource.add(R.drawable.g);
        imageResource.add(R.drawable.h);
        imageResource.add(R.drawable.i);
        imageResource.add(R.drawable.j);
        imageResource.add(R.drawable.k);
        imageResource.add(R.drawable.l);
        imageResource.add(R.drawable.m);
        imageResource.add(R.drawable.n);
        imageResource.add(R.drawable.o);
        imageResource.add(R.drawable.p);
        imageResource.add(R.drawable.q);
        imageResource.add(R.drawable.r);
        imageResource.add(R.drawable.s);
        imageResource.add(R.drawable.t);
        imageResource.add(R.drawable.u);
        imageResource.add(R.drawable.v);
        imageResource.add(R.drawable.w);
        imageResource.add(R.drawable.x);
        imageResource.add(R.drawable.y);
        imageResource.add(R.drawable.z);

        imageView.setImageResource(imageResource.get(currentIndex));

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    currentIndex = imageResource.size() - 1;
                }
                updateImage();
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex < imageResource.size() - 1) {
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }
                updateImage();
            }
        });


    }

    private void updateImage() { imageView.setImageResource(imageResource.get(currentIndex)); }
}