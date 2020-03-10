package com.example.horaveterinaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.horaveterinaria.Modelo.AgendaDatabaseHelper;
import com.example.horaveterinaria.Modelo.Cita;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AgendaDatabaseHelper helper=new AgendaDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nuevaCita(View view)
    {
        Intent intent=new Intent(this,NuevaCita.class);
        startActivity(intent);
    }

    public void eliminarCaducados(View view)
    {
        String msg=helper.eliminarCaducados();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void verAgenda(View view)
    {
        try
        {
            ArrayList<Cita> citas=(ArrayList<Cita>) helper.listaCitas();
            Intent intent=new Intent(this,AgendaActivity.class);
            startActivity(intent);
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Agenda vacia", Toast.LENGTH_SHORT).show();
        }
    }
}
