package model;

public class Bebida extends Producto {
    double volumenEnMl;
    double precioPorUnidad;

    Bebida(String nombre, double precioPorUnidad, double volumenEnMl, int unidad) {
        super(nombre, 0, 0);
        this.precioPorUnidad = precioPorUnidad;
        this.volumenEnMl = volumenEnMl;
        this.unidad = unidad;
        calcularPrecio();
    }

    private void calcularPrecio() {
        this.precio = precioPorUnidad * unidad;
    }

    @Override
    public String toString() {
        return String.format("%s - VolumenBebida: %.2fml - PrecioPorUnidad: $%.2f", super.toString(), volumenEnMl,
                precioPorUnidad);
    }
}