import java.util.ArrayList;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

import utilidades.Leer;

/*2.	Escribe un proyecto en Java que permita gestionar la venta de billetes de tren.

Crea las clases que se necesiten, los m�todos adecuados en cada clase y las colecciones que sean m�s adecuadas. 
(crea tres trenes de forma fija)
�	Cada tren se identifica con un n�mero de tren,  una hora de salida y las estaciones de salida y llegada. 
El n�mero de tren es �nico.
�	El tren para una fecha se compondr� de vagones.
Cada vag�n tiene una capacidad de 10 asientos, numerados del 1 al 10. 
Los vagones se numeran secuencialmente. Al tren se le van a�adiendo vagones seg�n se van llenando.
(cada vag�n se puede guardar en un array de 11 elementos en el que la posici�n 0.
se guarda el n�mero de vag�n y de las posiciones 1 a la 10 un 0 si est�n libres � un 1 si est�n ocupados. 
Tambi�n se puede guardar el n�mero del billete en el que se ha vendido).
�	La venta de billetes se realiza para una fecha (utiliza la clase Fecha) en un tren concreto, un vag�n y un asiento. (atributos de la clase billete: n�mero, fecha, tren, vag�n, asiento y precio) Cada billete lleva su precio y su n�mero identificador.
�	Los billetes se pueden devolver (borrar el billete), lo que dejar� el asiento correspondiente libre que ser�n los primeros en ser ofertados en la siguiente venta para la fecha correspondiente. Los billetes se guardan en una list o set.
�	Los billetes podr�n ser ordenada por diferentes criterios: 
o	n�mero de billete: datos de billetes (de billetes)
o	fecha, tren, vag�n y asiento: (este puede salir del mapa con clave la fecha y valor que puede ser el billete).
o	tren, fecha, vag�n : asientos vendidos (de billetes)
�	El men� del programa tiene venta de billetes, anulaci�n de billetes y listados por las tres opciones anteriores.
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Fecha, ArrayList<Tren>> trenes = new TreeMap<Fecha, ArrayList<Tren>>();
		
		crearTren(trenes,new Fecha(27, 04, 2018));
		crearTren(trenes,new Fecha(27, 04, 2018));
		crearTren(trenes,new Fecha(27, 04, 2018));

		for (Entry<Fecha, ArrayList<Tren>> tren : trenes.entrySet()) {
			Leer.mostrarEnPantalla(tren.getKey() + tren.getValue().toString());
		}
		ArrayList<Billete> billetes = new ArrayList<Billete>();
		for (int i = 0; i < 100; i++) {
			Iterator<Fecha> it = trenes.keySet().iterator();
			int trenazar = (int) (Math.random() * trenes.size());
			Fecha fecha = it.next();
			for (int j = 0; j < trenazar; j++) {
				fecha = it.next();
			}
			Tren tren = trenes.get(fecha).get((int) (Math.random() * trenes.get(fecha).size()));
			Integer vagon = tren.buscarVagon()+1;
			Integer asiento = tren.getVagones().get(vagon-1).asientoVacio();
			tren.venderBillete();
			billetes.add(new Billete(fecha, vagon, tren, asiento));
		}
		for (Billete billete : billetes) {
			Leer.mostrarEnPantalla(billete.toString());
		}
		Leer.mostrarEnPantalla("---------------------------------------------------");
		for (Entry<Fecha, ArrayList<Tren>> tren : trenes.entrySet()) {
			Leer.mostrarEnPantalla(tren.getKey() + tren.getValue().toString());
		}
	}

	private static void crearTren(TreeMap<Fecha, ArrayList<Tren>> trenes,Fecha fecha) {
		ArrayList<Tren> nuevo;
		trenes.get(fecha).add(new Tren());
	}
}
