package com.inventario.model;

public class Medicamento {
    private long id;
    private String nombre;
    private long precio;
    private String fechaDeVencimiento;
    private String categoria;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public long getPrecio() { return precio; }
    public void setPrecio(long precio) { this.precio = precio; }

    public String getFechaDeVencimiento() { return fechaDeVencimiento; }
    public void setFechaDeVencimiento(String fecha) { this.fechaDeVencimiento = fecha; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
