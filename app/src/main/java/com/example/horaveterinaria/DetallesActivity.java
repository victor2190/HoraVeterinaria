package com.example.horaveterinaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.horaveterinaria.Modelo.AgendaDatabaseHelper;
import com.example.horaveterinaria.Modelo.Cita;

public class DetallesActivity extends AppCompatActivity {

    private Cita  cita;
    private Intent intent;
    private AgendaDatabaseHelper helper=new AgendaDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        intent=getIntent();

        String nombreMascota=(String) intent.getExtras().get("");
    }
}
