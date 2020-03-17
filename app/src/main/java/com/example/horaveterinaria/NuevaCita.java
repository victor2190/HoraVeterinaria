package com.example.horaveterinaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.horaveterinaria.Modelo.AgendaDatabaseHelper;
import com.example.horaveterinaria.Modelo.Cita;

public class NuevaCita extends AppCompatActivity {

    private AgendaDatabaseHelper helper=new AgendaDatabaseHelper(this);
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
        int edad=0;
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
        float peso=0;
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

        if(edad<0)
        {
            Toast.makeText(this, "Edad debe ser mayor a cero", Toast.LENGTH_SHORT).show();
        }
        else if(peso<0)
        {
            Toast.makeText(this, "Peso debe ser mayor a 0", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Cita cita=new Cita(rNombre,rEspecie,edad,peso,rDueño,rTelefono,rFecha,hora);
            helper.ingresarCita(cita);
            Toast.makeText(this, "Cita ingresada correctamente", Toast.LENGTH_SHORT).show();
            finish();
        }


    }
}
