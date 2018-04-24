import java.util.ArrayList;
import java.util.List;

import utilidades.Leer;

/*Ejercicio 5.
Simulaci�n de colas de espera en una oficina de atenci�n a clientes.
En una oficina de atenci�n a clientes se disponen de 5 ventanillas para los mismos,
cada una de ellas genera una cola de espera.
Cada nodo de informaci�n que se inserta en la cola tiene una tarea a despachar que
puede ser de duraci�n 10 min, 20 min � 30 min , se ha estimado estad�sticamente que
llegan un 60% de tareas de duraci�n 10 un 25% de tareas de duraci�n 20 y un 15% de
tareas de duraci�n 30.
El programa debe generar con los porcentajes descritos un nodo de tipo 15, 20 o 30. Se
sugiere generar n�meros aleatorios entre 1 y 100 de manera que si el n�mero
generado est� entre 1 y 60 la tarea ser� de duraci�n 15, si est� entre 61 y 85 de
duraci�n 20 y si est� entre 86 y 100 de duraci�n 30.
Cuando se genera un cliente(es decir nodo � tarea), este se coloca en la cola cuya
longitud es m�nima.
Se ha estimado estad�sticamente tambi�n que cada 5 minutos llega un nuevo cliente
(nodo/tarea).
El programa debe simular el comportamiento de las 5 colas durante 5 horas es decir se
genera un bucle de 1 a 300 porque son trescientos minutos los que transcurren en ese
intervalo. Para cada minuto, es decir para cada paso del bucle hay que hacer dos cosas:
1. Si el minuto es m�ltiplo de 5 generar un cliente (tarea/nodo) y ponerlo en su cola
correspondiente.
2. Dar servicio a las 5 ventanillas esto es las tareas que est�n en el frente de cada cola
descontarles un minuto que ha transcurrido y si quedan en cero suprimirlas de la
cola.
El programa debe darnos las longitudes de cada cola de espera (ventanilla) cada 15
minutos. Y al final la longitud media de cada cola, obtenidas como la suma de las
longitudes de dicha cola en cada instante dividida por el n�mero de instantes totales
Los m�todos que se proponen para este ejercicio de simulaci�n son las siguientes:
ServirColas : su tarea es dar servicio a las 5 colas decrementando en uno los minutos
de su gesti�n , a las cabeceras de dichas colas y en el caso de que los minutos de ese
nodo queden a cero suprimirlos de la cola.
MedirCola : su funci�n es darnos el n�mero de nodos de la cola en un momento dado.
AsignarCola : su funci�n es indicar donde debe insertarse la tarea que se genera cada 5
minutos.
InsertarTarea : insertar una tarea en la cola que le corresponda.
ExtraerTarea : eliminar una tarea cuyo n�mero de minutos haya terminado.
Estos m�todos ser�n indispensables para la buena ejecuci�n del programa, pero si se
considera oportuno, se pueden crear otros m�todos auxiliares.*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Cliente>> colas = new ArrayList<ArrayList<Cliente>>();
		for (int i = 0; i < 5; i++) {// Crear cinco arrayList que haran la
										// funcion de colas
			colas.add(new ArrayList<Cliente>());
		}

		int contador = 0;
		while (contador < 300) {

			if (contador % 5 == 0) {
				colas.get(colaMenor(colas)).add(crearCliente(colas));

			}
			for (int i = 0; i < 5; i++) {
				if (!colas.get(i).isEmpty()) {
					colas.get(i).get(0).atencion();
					Leer.mostrarEnPantalla(colas.get(i).get(0).toString()+" Atendido");
					if (colas.get(i).get(0).terminado()) {
						Leer.mostrarEnPantalla(colas.get(i).get(0).toString()+ " Sale de la cola");
						colas.get(i).remove(0);
					}
				}

			}
			contador++;
		}

		for (ArrayList<Cliente> p : colas) {
			for (Cliente cliente : p) {
				Leer.mostrarEnPantalla(cliente.toString());
			}
		}
	}

	private static Cliente crearCliente(ArrayList<ArrayList<Cliente>> colas) {
		Cliente cliente = null;
		int tipo = (int) Math.random() * 101;
		if (tipo > 86) {
			cliente = new Cliente(30, colaMenor(colas));
		} else if (tipo < 86 && tipo > 60) {
			cliente = new Cliente(20, colaMenor(colas));
		} else {
			cliente = new Cliente(10, colaMenor(colas));
		}
		return cliente;
	}

	private static Integer colaMenor(ArrayList<ArrayList<Cliente>> colas) {
		Integer menor = 0;
		int contador = 0;
		int longitud = (colas.get(0)).size();
		for (ArrayList<Cliente> cola : colas) {
			if (cola.size() < longitud) {
				menor = contador;
			}
			contador++;
		}
		return menor;
	}

}