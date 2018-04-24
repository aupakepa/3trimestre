import java.util.ArrayList;

/*1.	Escribe un proyecto en Java que tenga: 

Una clase llamada Comedor en la que estará el método public static void main() 
y en la que se instanciarán los objetos de las clases que sean necesarias para:

•	El restaurante elabora una serie de platos que se componen de los productos que tiene en su lista de ingredientes.
 Cada plato tiene como precio el de la suma de ingredientes más un fijo que es de 1 euro 
 (gasto de luz, utensilios, tiempo,…)
•	Mostrar la carta de cada día de un restaurante que se compondrá de 6 platos de la lista de platos 
que elabora el restaurante. En cada plato se mostrarán los ingredientes que lo componen y el precio de ese plato. 
•	Cada menú consta de dos platos que es lo que cada cliente solicitará. 
A la bebida y el postre invita la casa. 
•	A cada cliente que vaya al restaurante se le anotarán los platos que han formado su menú y la mesa en que está.
 A la hora de pagar se mostrará la cuenta en pantalla: el detalle de los menús que tiene que pagar (los de la mesa), 
 indicando el precio de cada plato y el de cada menú, el total a pagar, el dinero entregado y el cambio. 

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
		ingredientes.add(new Ingredientes("champiñon", 1));
		ingredientes.add(new Ingredientes("piña", 1));
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
