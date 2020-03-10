package com.example.horaveterinaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NuevaCita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_cita);
    }
    public void ingresarCita(View view)
    {
        String rNombre=((TextView) findViewById(R.id.nombre)).getText().toString();
        String rEspecie=((Spinner) findViewById(R.id.especie)).getSelectedItem().toString();
        String rEdad=((TextView) findViewById(R.id.edad)).getText().toString();
        int edad;
        try
        {
            edad=Integer.parseInt(rEdad);
        }
        catch (NumberFormatException ex)
        {
            Toast.makeText(this,
                    "Edad ingresada no valida",Toast.LENGTH_SHORT).show();
        }

        String rPeso=((TextView) findViewById(R.id.peso)).getText().toString();
        float peso;
        try
        {
            peso=Float.parseFloat(rPeso);
        }
        catch (NumberFormatException ex)
        {
            Toast.makeText(this,
                    "Peso ingresado no valido", Toast.LENGTH_SHORT).show();
        }

        String rDueño=((TextView) findViewById(R.id.dueño)).getText().toString();
        String rTelefono=((TextView) findViewById(R.id.telefono)).getText().toString();
        String rFecha=((TextView) findViewById(R.id.fecha)).getText().toString();

        String rHora=((Spinner) findViewById(R.id.hra)).getSelectedItem().toString();
        String rMinutos=((Spinner) findViewById(R.id.min)).getSelectedItem().toString();
        String hora=rHora+":"+rMinutos;




    }
}
