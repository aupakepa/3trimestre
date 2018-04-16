import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/*2) EjerTresSetString
Hacer lo mismo que en el ejercicio anterior pero con conjuntos de String y asignando los
elementos al azar a partir de un vector de Strings.
Ejemplo de ejecuci�n:
Se van a generar 8 datos.
Insertando:
este * monta�a * letra * bajo * frio * bajo * bajo * aleatorio *
Valores de objHashSet (no hay orden):
este frio aleatorio bajo letra monta�a
Valores de objLinkHashSet (por orden de inserci�n):
este monta�a letra bajo frio aleatorio
Valores de objTreeSet (orden alfab�tico):
aleatorio bajo este frio letra monta�a
Valores de objHashSet: [este, frio, aleatorio, bajo, letra, monta�a]
Valores de objLinkHashSet: [este, monta�a, letra, bajo, frio, aleatorio]
Valores de objTreeSet: [aleatorio, bajo, este, frio, letra, monta�a]*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String vector [] = {"este","monta�a","letra","bajo","frio","bajo","bajo","aleatorio"};
		HashSet <String> has = new HashSet<String>();
		TreeSet <String> tree = new TreeSet<String>();
		LinkedHashSet<String> linked = new LinkedHashSet<String>();
		for (int i = 0; i < vector.length; i++) {
			has.add(vector[i]);
			linked.add(vector[i]);
			tree.add(vector[i]);
		}
		System.out.println();
		System.out.println("-------------------------------");
		System.out.print("Valores de LinkedHashSet: [");
		for (String string : linked) {
			System.out.print(string+",");
		}
		System.out.println("]");
		System.out.println("-------------------------------");
		System.out.print("Valores de objHashSet: [");
		for (String string : has) {
			System.out.print(string+",");
		}
		System.out.println("]");
		System.out.println("-------------------------------");
		System.out.print("Valores de objtreeSet: [");
		for (String string : tree) {
			System.out.print(string+",");
		}
		System.out.println("]");
	}

}
