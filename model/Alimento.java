package model;

public class Alimento extends Producto {
	double pesoEnGramos;
	double valorPorGramo;

	Alimento(String nombre, double valorPorGramo, double pesoEnGramos) {
		super(nombre, 0, 0);
		this.pesoEnGramos = pesoEnGramos;
		this.valorPorGramo = valorPorGramo;
		calcularPrecio();
	}

	private void calcularPrecio() {
		this.precio = valorPorGramo * pesoEnGramos;
	}

	@Override
	public String toString() {
		return String.format("%s - PesoGramos: %.2fg - ValorPorGramo: $%.2f", super.toString(), pesoEnGramos,
				valorPorGramo);
	}
}
