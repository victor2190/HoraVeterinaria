package com.example.horaveterinaria.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AgendaDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="veterinaria.db";
    private static final int DB_VERSION=1;


    public AgendaDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTxt="CREATE TABLE AGENDA("+
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "NOMBRE TEXT, ESPECIE TEXT, EDAD INTEGER,"+
                "PESO FLOAT, DUEÑO TEXT, TELEFONO TEXT, "+
                "FECHA TEXT, HORA TEXT, ESTADO TEXT);";
        db.execSQL(sqlTxt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //ingresando datos a la BD
    public void ingresarCita(Cita cita)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put("NOMBRE", cita.getNombre());
        valores.put("ESPECIE", cita.getEspecie());
        valores.put("EDAD", cita.getEdad());
        valores.put("PESO", cita.getPeso());
        valores.put("DUEÑO", cita.getDueño());
        valores.put("TELEFONO", cita.getTelefono());
        valores.put("FECHA", cita.getFecha());
        valores.put("HORA", cita.getHora());
        valores.put("ESTADO", cita.getEstado());

        db.insert("AGENDA", null, valores);


    }

    //mostrando registros
    public List<Cita> listaCitas()
    {
        List<Cita> citas=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.query("AGENDA", new String[]
                {"ID","NOMBRE","ESPECIE","EDAD","PESO","DUEÑO",
                "TELEFONO","FECHA","HORA","ESTADO"},
                null,null,null,
                null,null);
        cursor.moveToFirst();


        do{
            citas.add(new Cita(
                    cursor.getInt(0),//ID
                    cursor.getString(1),//nombre
                    cursor.getString(2),//especie
                    cursor.getInt(3),//edad
                    cursor.getFloat(4),//peso
                    cursor.getString(5),//dueño
                    cursor.getString(6),//telefono
                    cursor.getString(7),//fecha
                    cursor.getString(8),//hora
                    cursor.getString(9)//estado
                    ));
        }
        while(cursor.moveToNext());

        cursor.close();
        db.close();

        return citas;
    }
    //obtener detalles de la cita
    public Cita getCita(int id)
    {
        Cita c;
        SQLiteDatabase db=getReadableDatabase();
        String sqlText="SELECT *" +
                "FROM AGENDA " +
                "WHERE ID=?";
        String [] argumentos=new String[]{String.valueOf(id)};//puede que esto de error...no deberia
        try
        {
            Cursor cursor=db.rawQuery(sqlText,argumentos);
            cursor.moveToFirst();

            c=new Cita(
                    cursor.getInt(0),//id
                    cursor.getString(1),//nombre
                    cursor.getString(2),//especie
                    cursor.getInt(3),//edad
                    cursor.getFloat(4),//peso
                    cursor.getString(5),//dueño
                    cursor.getString(6),//telefono
                    cursor.getString(7),//fecha
                    cursor.getString(8),//hora
                    cursor.getString(9)//estado
            );
        }
        catch (SQLException ex) {
            c = null;
        }
        return c;
    }
    //actualizar
    public String cambiaConfirmado(Cita c)
    {

        String sqlTxt="UPDATE AGENDA SET CONFIRMADO=? WHERE ID=?";
        Object[] argumentos=new Object[]{c.getEstado(), c.getId()};

        try
        {
            getWritableDatabase().execSQL(sqlTxt, argumentos);
            return "Cita actualizada";
        }
        catch (SQLException ex)
        {
            return "Cambios no guardados";
        }
    }

    //eliminar
    public String eliminarCaducados()
    {
        String sqlTxt="DELETE FROM AGENDA WHERE ESTADO='CADUCADO'";
        try
        {
            getWritableDatabase().execSQL(sqlTxt);
            return "Citas caducadas eliminadas";
        }
        catch (SQLException ex)
        {
            return "Registros no eliminados";
        }
    }



}
