package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ImageView shirt;
    ImageView pants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        //display the logo during 5 seconds,
        new CountDownTimer(2000,1000){
            @Override
            public void onTick(long millisUntilFinished){}

            @Override
            public void onFinish(){
                //set the new Content of your activity
                MainActivity.this.setContentView(R.layout.activity_main);
                shirt = findViewById(R.id.imageShirt);
                pants = findViewById(R.id.imagePants);
                final Intent intent = new Intent(getApplicationContext(), MedidasActivity.class);
                shirt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intent);
                    }
                });
                pants.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intent);
                    }
                });
            }
        }.start();
    }
}