package model;

import java.util.LinkedHashSet;

public class Inventario {
    private LinkedHashSet<Producto> inventario = new LinkedHashSet<>();

    public void agregarProducto(String nombre, TipoProducto tipo, double gramo, double valorPorGramo, int unidad,
                                double precioPorUnidad, double volumenEnMl) {
        Producto nuevoProducto = null;
        switch (tipo) {
            case ALIMENTO:
                nuevoProducto = new Alimento(nombre, valorPorGramo, gramo);
                break;
            case BEBIDA:
                if (precioPorUnidad <= 0 || unidad <= 0 || volumenEnMl <= 0) {
                    throw new IllegalArgumentException(
                            "El precio por unidad, la unidad y el volumen deben ser mayores que cero.");
                }
                nuevoProducto = new Bebida(nombre, precioPorUnidad, volumenEnMl, unidad);
                break;
            default:
                throw new IllegalArgumentException("Tipo de producto no válido.");
        }
        if (nuevoProducto != null) {
            inventario.add(nuevoProducto);
        }
    }

    public String buscarProducto(String clave) {
        for (Producto producto : inventario) {
            if (producto.nombre.equalsIgnoreCase(clave) || Integer.toString(producto.id).equals(clave)) {
                return "Producto encontrado:\n" + producto;
            }
        }
        return "Producto no encontrado en el inventario.";
    }

    public String eliminarProducto(String clave) {
        boolean encontrado = false;
        Producto productoEliminado = null;
        for (Producto producto : inventario) {
            if (producto.nombre.equalsIgnoreCase(clave) || Integer.toString(producto.id).equals(clave)) {
                encontrado = true;
                productoEliminado = producto;
                break;
            }
        }
        if (encontrado) {
            inventario.remove(productoEliminado);
            return "Producto eliminado del inventario.";
        } else {
            return "Producto no encontrado en el inventario.";
        }
    }

    public String verInventario() {
        if (inventario.isEmpty()) {
            return "El inventario está vacío.";
        } else {
            StringBuilder inventarioString = new StringBuilder("Inventario ordenado por orden de inserción:\n");
            for (Producto producto : inventario) {
                inventarioString.append(producto).append("\n");
            }
            return inventarioString.toString();
        }
    }

    public double valorInventario() {
        double valorTotal = 0;
        for (Producto producto : inventario) {
            valorTotal += producto.precio;
        }
        return valorTotal;
    }
}