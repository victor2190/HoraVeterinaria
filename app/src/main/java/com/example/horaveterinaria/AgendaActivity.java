package com.example.horaveterinaria;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.horaveterinaria.Modelo.AgendaDatabaseHelper;
import com.example.horaveterinaria.Modelo.Cita;

import java.util.List;


public class AgendaActivity extends ListActivity
{

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        cargarLista();
    }

    public void cargarLista()
    {
        lista=getListView();

        AgendaDatabaseHelper helper=new AgendaDatabaseHelper(this);
        List<Cita> citaList= helper.listaCitas();

        ArrayAdapter<Cita> listaAdapter=new ArrayAdapter<Cita>(this,
                android.R.layout.simple_expandable_list_item_1,citaList);

        lista.setAdapter(listaAdapter);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int posicion,long id)
    {
        Object o=lista.getItemAtPosition(posicion);
        String linea=o.toString();
        String[] separar=linea.split(":");

        Intent intent=new Intent(AgendaActivity.this, DetallesActivity.class);
        intent.putExtra("id", separar[0]);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1) {
            if (resultCode == RESULT_OK) {
                cargarLista();
            }
        }
    }

}
