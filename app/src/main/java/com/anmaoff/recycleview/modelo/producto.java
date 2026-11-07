package com.anmaoff.recycleview.modelo;

public class producto {
    private int Clave;
    private String Name;
    private int Cantidad;
    private double Precio;
    private String Categoria;
    private String Descripcion;
    private String Responsable;

    public String getResponsable() {
        return Responsable;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public double getPrecio() {
        return Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public String getName() {
        return Name;
    }

    public int getClave() {
        return Clave;
    }

    public void setResponsable(String responsable) {
        Responsable = responsable;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setClave(int clave) {
        Clave = clave;
    }
}
