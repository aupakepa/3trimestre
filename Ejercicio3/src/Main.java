import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import utilidades.Leer;

/*Ejercicio 3.
Ejercicio 3.
En este ejercicio se generan los datos a partir de dos vectores de 10 nombres y 10
apellidos combin�ndolos al azar. Hay que generar un ArrayList de 50 alumnos para
guardar el nombre, el apellido y las notas obtenidas en tres ex�menes parciales que se
punt�an entre 0 y 100.
El programa debe:
1. Generar al azar los datos de 50 alumnos. Cada alumno se almacenar� en un
elemento del ArrayList. Los datos que queremos guardar de cada alumno son:
string nombre;
string apellido;
int nota1;
int nota2;
int nota3;
2. Despu�s generar tres mapas (TreeMap), uno para cada nota, donde la key ser� la
nota por la que ordenamos y el dato asociado un ArrayList con los �ndices del
vector donde aparece esa nota (puede haber varios alumnos que tengan la misma
nota).
3. Presentar un men� para poder listar la clase por cualquiera de las tres notas en
orden ascendente, es decir ascen1�, ascen2�, ascen3�.
4. Presentar en pantalla el listado requerido
De esta forma no hay que reordenar el ArrayList cada vez que se pide un tipo de
listado pues el ArrayList, aunque este desordenado, es accesible en el orden de las
notas seg�n el mapa que se recorra.*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String apellidos[] = { "Perez", "Martinez", "Monforte", "Taboada", "Rodriguez", "Buj", "Lopez", "Notivol",
				"Bezares", "Sans" };
		String nombres[] = { "Javier", "Ruben", "Juan", "Martin", "Guillermo", "Felipe", "Alberto", "Maria", "Lucia",
		"Raquel" };
		List<Alumnos> alumnos = new ArrayList<Alumnos>();
		for (int i = 0; i < 50; i++) {
			int j = (int) (Math.random() * 10);
			int k = (int) (Math.random() * 10);
			int nota1 = (int) (Math.random() * 101);
			int nota2 = (int) (Math.random() * 101);
			int nota3 = (int) (Math.random() * 101);
			alumnos.add(new Alumnos(nombres[j], apellidos[k], nota1, nota2, nota3));

		}
		for (Alumnos alumno : alumnos) {
			Leer.mostrarEnPantalla(alumno.toString());
		}
		TreeMap<Integer, ArrayList<Alumnos>> notas = new TreeMap<>();
		ArrayList<Alumnos> alumnosnota1;	
		for (int i = 0; i < alumnos.size(); i++) {

			Integer nota = alumnos.get(i).getNota1();
			Alumnos alumno = alumnos.get(i);
			if (notas.containsKey(nota)) {
				alumnosnota1 = notas.get(nota);
				alumnosnota1.add(alumno);
			} else {
				alumnosnota1 = new ArrayList<Alumnos>();
				alumnosnota1.add(alumno);
				notas.put(nota, alumnosnota1);
			}
		}

			
			for (Entry<Integer, ArrayList<Alumnos>> alumnos2 : notas.entrySet()) {
			Leer.mostrarEnPantalla(alumnos2.getKey().toString());
			Leer.mostrarEnPantalla(alumnos2.getValue().toString());
			}
		}
		
	}

