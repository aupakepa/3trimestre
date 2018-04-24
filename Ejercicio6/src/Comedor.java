import java.util.ArrayList;

/*1.	Escribe un proyecto en Java que tenga: 

Una clase llamada Comedor en la que estar� el m�todo public static void main() 
y en la que se instanciar�n los objetos de las clases que sean necesarias para:

�	El restaurante elabora una serie de platos que se componen de los productos que tiene en su lista de ingredientes.
 Cada plato tiene como precio el de la suma de ingredientes m�s un fijo que es de 1 euro 
 (gasto de luz, utensilios, tiempo,�)
�	Mostrar la carta de cada d�a de un restaurante que se compondr� de 6 platos de la lista de platos 
que elabora el restaurante. En cada plato se mostrar�n los ingredientes que lo componen y el precio de ese plato. 
�	Cada men� consta de dos platos que es lo que cada cliente solicitar�. 
A la bebida y el postre invita la casa. 
�	A cada cliente que vaya al restaurante se le anotar�n los platos que han formado su men� y la mesa en que est�.
 A la hora de pagar se mostrar� la cuenta en pantalla: el detalle de los men�s que tiene que pagar (los de la mesa), 
 indicando el precio de cada plato y el de cada men�, el total a pagar, el dinero entregado y el cambio. 

*/
public class Comedor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Platos> platos = new ArrayList<Platos>();
		ArrayList<Ingredientes> ingredientes = new ArrayList<Ingredientes>();
		ingredientes.add(new Ingredientes("Tomate", 1));
		ingredientes.add(new Ingredientes("Pasta", 1));
		ingredientes.add(new Ingredientes("Queso parmesano", 1.5));
		ingredientes.add(new Ingredientes("Albaca", 1));
		ingredientes.add(new Ingredientes("Pesto", 1));
		ingredientes.add(new Ingredientes("Nata", 1));
		ingredientes.add(new Ingredientes("panceta", 1));
		ingredientes.add(new Ingredientes("champi�on", 1));
		ingredientes.add(new Ingredientes("pi�a", 1));
		ingredientes.add(new Ingredientes("Queso Azul", 1));
		ingredientes.add(new Ingredientes("Cebolla", 1));
		
		ArrayList<Ingredientes> componentes = new ArrayList<Ingredientes>(); 
		componentes.add(ingredientes.get(6));
		componentes.add(ingredientes.get(5));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza Carbonara",componentes));

		componentes.clear();
		
		componentes.add(ingredientes.get(0));
		componentes.add(ingredientes.get(4));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza Al pesto",componentes));

		componentes.clear();
		
		componentes.add(ingredientes.get(8));
		componentes.add(ingredientes.get(0));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza Hawayana",componentes));

		componentes.clear();
		
		componentes.add(ingredientes.get(9));
		componentes.add(ingredientes.get(1));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza de quesos",componentes));

		componentes.clear();
		
	
		componentes.add(ingredientes.get(6));
		componentes.add(ingredientes.get(1));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza Margarita",componentes));

		componentes.clear();
		
		componentes.add(ingredientes.get(9));
		componentes.add(ingredientes.get(6));
		componentes.add(ingredientes.get(10));
		platos.add(new Platos("Pizza de la casa",componentes));

		componentes.clear();
	}

}
