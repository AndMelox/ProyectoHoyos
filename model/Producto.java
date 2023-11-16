package model;

public class Producto {
    static int contadorProductos = 0;
    int id;
    String nombre;
    double precio;
    int unidad;
    double gramos;

    Producto(String nombre, double precio,int unidad) {
        this.id = ++contadorProductos;
        this.nombre = nombre;
        this.precio = precio;
        this.unidad=unidad;
    }

    @Override
    public String toString() {
        return String.format("ID: %d - %s - $%.2f", id, nombre, precio);
    }
}