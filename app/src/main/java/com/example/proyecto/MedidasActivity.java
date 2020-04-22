package com.example.proyecto;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MedidasActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    ConstraintLayout constraint_medidas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medidas_activity);
        constraint_medidas = findViewById(R.id.constraint_medidas);
        sharedpreferences = getSharedPreferences("medidas", Context.MODE_PRIVATE);

        final ArrayList<EditText> medidas = new ArrayList<>();
        for( int i = 0; i < constraint_medidas.getChildCount(); i++ ){
            if( constraint_medidas.getChildAt( i ) instanceof EditText ){
                medidas.add( (EditText) constraint_medidas.getChildAt( i ) );
            }
        }
        for (EditText medida: medidas) {
            medida.setText(Float.toString(sharedpreferences.getFloat(medida.getHint().toString(),0)));
        }


        Button btn_guardar = findViewById(R.id.btn_guardar_medidas);
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                for (EditText medida: medidas) {
                    editor.putFloat(medida.getHint().toString(), Float.parseFloat(medida.getText().toString()));
                }
                editor.apply();
                finish();
            }
        });
    }
}
