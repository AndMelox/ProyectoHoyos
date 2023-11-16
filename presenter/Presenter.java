package presenter;

import view.ViewJOptionPane;
import model.*;

public class Presenter {
	private Inventario model;
	private ViewJOptionPane view;

	public Presenter(Inventario model, ViewJOptionPane view) {
		this.model = model;
		this.view = view;
	}

	public void iniciar() {
		while (true) {
			try {
				int opcion = view.mostrarMenu();
				switch (opcion) {
				case 0:
					agregarProducto();
					break;
				case 1:
					buscarProducto();
					break;
				case 2:
					eliminarProducto();
					break;
				case 3:
					verInventario();
					break;
				case 4:
					mostrarValorInventario();
					break;
				case 5:
					salir();
					break;
				default:
					view.mostrarMensaje("Opción no válida. Por favor, seleccione un número del 1 al 6.");
				}
			} catch (Exception e) {
				view.mostrarMensaje("Ha ocurrido un error: " + e.getMessage());
			}
		}
	}

	private void agregarProducto() {
		try {
			String nombreProducto = view.leerNombreProducto();
			if (!nombreProducto.matches("[a-zA-Z]+")) {
				throw new Exception();
			}
			TipoProducto tipo = leerTipoProducto();
			double gramo = 0, valorPorGramo = 0, precioPorUnidad = 0, volumenEnMl = 0;
			int unidad = 0;
			if (tipo == TipoProducto.ALIMENTO) {
				gramo = view.leerValorNumerico("Ingrese los gramos del alimento:");
				valorPorGramo = view.leerValorNumerico("Ingrese el valor por gramo:");
			} else if (tipo == TipoProducto.BEBIDA) {
				unidad = view.leerCantidadUnidades();
				precioPorUnidad = view.leerValorNumerico("Ingrese el precio por unidad de la bebida:");
				volumenEnMl = view.leerVolumenMl();
			}
			model.agregarProducto(nombreProducto, tipo, gramo, valorPorGramo, unidad, precioPorUnidad, volumenEnMl);
		} catch (Exception e) {
			view.mostrarMensaje("Dato no Valido " + e.getMessage());

		}
	}

	private void buscarProducto() {
		try {
			String claveBusqueda = view.leerInput("Ingrese el nombre o ID del producto a buscar:");
			String resultadoBusqueda = model.buscarProducto(claveBusqueda);
			view.mostrarMensaje(resultadoBusqueda);
		} catch (Exception e) {
			view.mostrarMensaje("Ha ocurrido un error al buscar el producto: " + e.getMessage());
		}
	}

	private void eliminarProducto() {
		try {
			String claveEliminar = view.leerInput("Ingrese el nombre o ID del producto a eliminar:");
			model.eliminarProducto(claveEliminar);
		} catch (Exception e) {
			view.mostrarMensaje("Ha ocurrido un error al eliminar el producto: " + e.getMessage());
		}
	}

	private void verInventario() {
		try {
			String inventarioOrdenado = model.verInventario();
			view.mostrarMensaje(inventarioOrdenado);
		} catch (Exception e) {
			view.mostrarMensaje("Ha ocurrido un error al ver el inventario: " + e.getMessage());
		}
	}

	private void mostrarValorInventario() {
		try {
			double valorTotal = model.valorInventario();
			view.mostrarMensaje("Valor total del inventario: $" + valorTotal);
		} catch (Exception e) {
			view.mostrarMensaje("Ha ocurrido un error al mostrar el valor del inventario: " + e.getMessage());
		}
	}

	public TipoProducto leerTipoProducto() {
		String tipoStr = view.leerInput("Ingrese el tipo de producto (ALIMENTO o BEBIDA):").toUpperCase();
		return TipoProducto.valueOf(tipoStr);
	}

	private void salir() {
		view.mostrarMensaje("Saliendo del programa. ¡Hasta luego!");
		System.exit(0);
	}

	public static void main(String[] args) {
		Inventario model = new Inventario();
		ViewJOptionPane view = new ViewJOptionPane();
		Presenter presentador = new Presenter(model, view);
		
		presentador.iniciar();
	}
}