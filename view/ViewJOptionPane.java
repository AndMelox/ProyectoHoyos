package view;

import javax.swing.JOptionPane;

public class ViewJOptionPane {
    public int mostrarMenu() {
        String[] opciones = { "Agregar producto", "Buscar producto por nombre o ID",
                "Eliminar producto por nombre o ID", "Ver inventario", "Valor de inventario", "Salir" };
        return JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú", 0, JOptionPane.INFORMATION_MESSAGE,
                null, opciones, null);
    }

    public String leerNombreProducto() {
        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        return nombreProducto;
    }

    public double leerValorNumerico(String mensaje) {
        String valorStr = JOptionPane.showInputDialog(mensaje);
        if (valorStr == null || valorStr.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor no puede estar vacío.");
        }
        try {
            return Double.parseDouble(valorStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El valor ingresado no es un número válido.");
        }
    }

    public int leerCantidadUnidades() {
        String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad de unidades:");
        if (cantidadStr == null || cantidadStr.trim().isEmpty()) {
            throw new IllegalArgumentException("La cantidad no puede estar vacía.");
        }
        try {
            return Integer.parseInt(cantidadStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La cantidad ingresada no es un número válido.");
        }
    }

    public double leerVolumenMl() {
        String volumenStr = JOptionPane.showInputDialog("Ingrese el volumen en ml:");
        if (volumenStr == null || volumenStr.trim().isEmpty()) {
            throw new IllegalArgumentException("El volumen no puede estar vacío.");
        }
        try {
            return Double.parseDouble(volumenStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El volumen ingresado no es un número válido.");
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String leerInput(String mensaje) {
        String input = JOptionPane.showInputDialog(mensaje);
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor ingresado no puede estar vacío.");
        }
        return input;
    }

    public void mostrarInventario(String inventario) {
        JOptionPane.showMessageDialog(null, inventario);
    }
}
