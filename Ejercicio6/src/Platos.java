import java.util.ArrayList;

public class Platos {
	private String nombre;
	private Double precio;
	private ArrayList<Ingredientes> ingredientes;
	public Platos(String nombre, ArrayList<Ingredientes> ingredientes) {
		super();
		this.nombre = nombre;
		this.establecerPrecio();
		this.ingredientes = ingredientes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public ArrayList<Ingredientes> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	} 
	public void establecerPrecio() {
		Double precio = 1.0;
		for (int i = 0; i < ingredientes.size(); i++) {
			precio = precio + ingredientes.get(i).getCoste();
		}
		this.setPrecio(precio);
	} 
}
