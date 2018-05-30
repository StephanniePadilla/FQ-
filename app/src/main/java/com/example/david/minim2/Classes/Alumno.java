package com.example.david.minim2.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("instituto")
    @Expose
    private String instituto;

    @SerializedName("numOperaciones")
    @Expose
    private int numOperaciones = 0;


    public Alumno() {
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", instituto='" + instituto + '\'' +
                ", numOperaciones=" + numOperaciones +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public int getNumOperaciones() {
        return numOperaciones;
    }

    public void setNumOperaciones(int numOperaciones) {
        this.numOperaciones = numOperaciones;
    }

}
