package com.example.horaveterinaria.Modelo;

public class Cita {

    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private float peso;
    private String dueño;
    private String telefono;
    private String fecha;
    private String hora;
    private String estado;

    public Cita(String nombre, String especie, int edad, float peso, String dueño, String telefono, String fecha, String hora) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.dueño = dueño;
        this.telefono = telefono;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = "Agendado";
    }

    public Cita(int id, String nombre, String especie, int edad, float peso, String dueño, String telefono, String fecha, String hora, String estado) {
        this.id=id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.dueño = dueño;
        this.telefono = telefono;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    public float getPeso() {
        return peso;
    }

    public String getDueño() {
        return dueño;
    }

    public String getTelefono() { return telefono; }

    public String getFecha() { return fecha; }

    public String getHora() {
        return hora;
    }

   public String getEstado()
   {
       return estado;
   }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
