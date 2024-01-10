package com.example.dictionarykoreann;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashScrean extends AppCompatActivity {
    ImageView imgicon;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screan);

        imgicon=findViewById(R.id.imgicon);
        txt=findViewById(R.id.txt);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splashScrean.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },1000);


        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.move);
        imgicon.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.fade);
        txt.startAnimation(animation2);

    }
}