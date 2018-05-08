import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

		ArrayList<Tren> trenes = new ArrayList<Tren>();
		trenes.add(new Tren(new Fecha(24, 04, 2018)));
		trenes.add(new Tren(new Fecha(27, 04, 2018)));
		trenes.add(new Tren(new Fecha(28, 04, 2018)));
		ArrayList<Billete> billetes = new ArrayList<Billete>();
		File t = new File("billetes.txt");
		File f = new File("trenes.txt");

		if (t.exists()) {
			Fichero leerFichero = new Fichero("billetes.txt", "I");
			billetes.add(leerFichero.leer());
			leerFichero.cerrar("I");
		}
		if (f.exists()) {
			Fichero2 leerTrenes = new Fichero2("trenes.txt", "I");
			trenes = leerTrenes.leer();
			leerTrenes.cerrar("I");
		}
		Collections.sort(billetes, billeteComparator);
		for (Tren tren : trenes) {
			if (Tren.siguiente <= tren.getNumero()) {
				Tren.siguiente = tren.getNumero() + 1;
			}
		}
		for (Billete billete : billetes) {
			if (billete.getNumBillete() >= Billete.siguiente) {
				Billete.siguiente = billete.getNumBillete() + 1;
			}
		}

		// for (int i = 0; i < 100; i++) {
		// int trenazar = (int) (Math.random() * trenes.size());
		// Tren trenactual = trenes.get(trenazar);
		// Integer vagon = trenactual.buscarVagon() + 1;
		// Fecha fecha = trenactual.getFecha();
		// Integer asiento = trenactual.getVagones().get(vagon -
		// 1).asientoVacio();
		// trenactual.venderBillete();
		// Billete ticket = new Billete(fecha, vagon, trenactual, asiento);
		// billetes.add(ticket);
		// Fichero escribirFichero;
		// escribirFichero = new Fichero("billetes.txt", "O");
		// escribirFichero.escribir(billetes); escribirFichero.cerrar("O");
		// Fichero2
		// escribirTrenes; escribirTrenes = new Fichero2("trenes.txt", "O");
		// escribirTrenes.escribir(trenes); escribirTrenes.cerrar("O");

		// }

		int menu = -1;
		do {
			Leer.mostrarEnPantalla("1.Venta de Billetes");
			Leer.mostrarEnPantalla("2.Anulacion de Billetes");
			Leer.mostrarEnPantalla("3.Orden por fechas");
			Leer.mostrarEnPantalla("4.Orden por num Tren");
			Leer.mostrarEnPantalla("5.Orden por num");
			Leer.mostrarEnPantalla("6.Listar Blletes");
			Leer.mostrarEnPantalla("0.Salir");
			Leer.mostrarEnPantalla("-------------------------");
			menu = Leer.pedirEntero("Introducir Opcion del menu");
			switch (menu) {
			case 1:
				int i = 1;
				for (Tren tren : trenes) {
					Leer.mostrarEnPantalla(i + ".-" + tren.toString());
					i++;
				}
				Leer.mostrarEnPantalla("-----------------------------");
				Tren trenactual = trenes.get(Leer.pedirEntero("introduzca el tren para el que desea el viaje") - 1);
				Fecha fecha = trenactual.getFecha();
				Integer vagon = trenactual.buscarVagon() + 1;
				Integer asiento = trenactual.getVagones().get(vagon - 1).asientoVacio();
				trenactual.venderBillete();
				Billete ticket = new Billete(fecha, vagon, trenactual, asiento);
				billetes.add(ticket);
				Fichero escribirFichero;
				escribirFichero = new Fichero("billetes.txt", "O");
				for (Billete billete : billetes) {
					escribirFichero.escribir(billete);
				}
				escribirFichero.cerrar("O");
				break;

			case 2:

				int numeroBillete = Leer.pedirEntero("introduce el numero de billete");

				int j = 0;
				int posicion = -1;
				for (Billete billete : billetes) {
					if (billete.getNumBillete() == numeroBillete) {
						posicion = j;
					}
					j++;
				}
				if (posicion != -1) {
					vagon = billetes.get(posicion).getVagon();
					asiento = billetes.get(posicion).getAsiento();
					trenactual = billetes.get(posicion).getTren();
					trenactual.anularBillete(vagon, asiento);
					if (posicion != -1) {
						billetes.remove(posicion);
						Leer.mostrarEnPantalla("Billete : " + numeroBillete + " anulado");
					} else {
						Leer.mostrarEnPantalla("El billete no es correcto");
					}
					escribirFichero = new Fichero("billetes.txt", "O");
					for (Billete billete : billetes) {
						escribirFichero.escribir(billete);
					}
					escribirFichero.cerrar("O");

				} else {
					Leer.mostrarEnPantalla("El numero de billete no existe");
				}

				break;

			case 3:
				Collections.sort(billetes, fechaComparator);

				for (Billete billete : billetes) {
					Leer.mostrarEnPantalla(billete.toString());
				}

				break;

			case 4:

				break;

			case 5:

				break;

			case 0:

				break;

			case 6:
				for (Billete billete : billetes) {
					Leer.mostrarEnPantalla(billete.toString());
				}
				for (Tren tren : trenes) {
					Leer.mostrarEnPantalla(tren.toString());
				}
				break;

			default:
				break;
			}
		} while (menu != 0);

		Collections.sort(trenes);
		Leer.mostrarEnPantalla("---------------------------------------");
		for (Tren tren : trenes) {
			Leer.mostrarEnPantalla(tren.toString());
		}
	}

	// private static void escribirDatos(ArrayList<Tren> trenes, Billete
	// billete) {
	// Fichero escribirFichero;
	// escribirFichero = new Fichero("billetes.txt", "O");
	// escribirFichero.escribir(billete);
	// escribirFichero.cerrar("O");
	// Fichero2 escribirTrenes;
	// escribirTrenes = new Fichero2("trenes.txt", "O");
	// escribirTrenes.escribir(trenes);
	// escribirTrenes.cerrar("O");
	// }

	public static Comparator<Billete> fechaComparator = new Comparator<Billete>() {

		public int compare(Billete billete1, Billete billete2) {

			int ordenFecha = -billete1.getFecha().difFechas(billete2.getFecha()) * 100;
			int ordenTren = (billete1.getTren().getNumero() - billete2.getTren().getNumero()) * 10000;
			int ordenVagon = (billete1.getVagon() - billete2.getVagon()) * 10;
			int ordenAsiento = billete1.getAsiento() - billete2.getAsiento();
			return (ordenFecha + ordenTren + ordenVagon + ordenAsiento);

		}
	};
	public static Comparator<Billete> billeteComparator = new Comparator<Billete>() {

		public int compare(Billete billete1, Billete billete2) {

			return (billete1.getNumBillete() - billete2.getNumBillete());

		}
	};
}