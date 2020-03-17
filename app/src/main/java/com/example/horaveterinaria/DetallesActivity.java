package com.example.horaveterinaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.horaveterinaria.Modelo.AgendaDatabaseHelper;
import com.example.horaveterinaria.Modelo.Cita;

public class DetallesActivity extends AppCompatActivity {

    private Cita  cita;
    private int id;
    private Intent intent;
    private AgendaDatabaseHelper helper=new AgendaDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        intent=getIntent();

        String idStr=(String) intent.getExtras().get("id");
        id=Integer.parseInt(idStr);//será necesario un catch????
        cita=helper.getCita(id);

        //Mostrar detalles cita
        TextView txtId=(TextView)findViewById(R.id.txtId);
        txtId.setText(cita.getId());

        TextView txtNombre=(TextView)findViewById(R.id.txtNombre);
        txtNombre.setText(cita.getNombre());

        TextView txtEspecie=(TextView)findViewById(R.id.txtEspecie);
        txtEspecie.setText(cita.getEspecie());

        TextView txtEdad=(TextView)findViewById(R.id.txtEdad);
        txtEdad.setText(cita.getEdad());

        TextView txtPeso=(TextView)findViewById(R.id.txtPeso);
        txtPeso.setText((int) cita.getPeso());//revisar si funcioona esto

        TextView txtDueño=(TextView)findViewById(R.id.txtDueño);
        txtDueño.setText(cita.getDueño());

        TextView txtTelefono=(TextView)findViewById(R.id.txtTelefono);
        txtTelefono.setText(cita.getTelefono());

        TextView txtFecha=(TextView)findViewById(R.id.txtFecha);
        txtFecha.setText(cita.getFecha());

        TextView txtHora=(TextView)findViewById(R.id.txtHora);
        txtHora.setText(cita.getHora());

        TextView txtEstado=(TextView)findViewById(R.id.txtEstado);
        Button cambiar=(Button)findViewById(R.id.estado);



    }
}
