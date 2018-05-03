import java.io.*;

import utilidades.Leer;

public class Fichero {
	private BufferedReader entrada;
	private BufferedWriter salida;

	public Fichero(String nombre, String io){
		//fin=false;
		if (io.equals("I")){//abrir el fichero para leer
			try{
				entrada=new BufferedReader(new FileReader(nombre));//asignar fichero a buffer
			}catch(IOException e){//controlar el error
				Leer.mostrarEnPantalla("Error al abrir el archivo de entrada "+e.getMessage());
				System.exit(1);
			}
		}
		if (io.equals("O")){//abrir el fichero para escribir
			try{
				salida=new BufferedWriter(new FileWriter(nombre));//asignar fichero a buffer
			}catch(IOException e){//controlar el error
				Leer.mostrarEnPantalla("Error al abrir el archivo de salida "+e.getMessage());
				System.exit(1);
			}
		}
	}
	
	public void leer( ){
		//Persona persona=null;
		String linea=null;
		String nombre= "", contraseña="";
		int edad=0;
		try {
			linea = entrada.readLine();//leemos un registro
			if(linea.length() != 0){// si tiene contenido procesamos sabiendo que separa cada campo y cuantos campos tiene
				// los valores de cada atributo estan separados por lo que devuelve getSeparador() En este caso ;
				if(linea.indexOf(Separable.getSeparador())!=-1){// recuperamos el valor del primer atributo		
					nombre= linea.substring(0, linea.indexOf(Separable.getSeparador()));
					contraseña = linea.substring(linea.indexOf(Separable.getSeparador()) + 1 );
				}
				
				// recuperamos el valor del tercer atributo
				try {
					edad = Integer.parseInt(linea);
				} catch(NumberFormatException e){
					Leer.mostrarEnPantalla("Datos erróneos se asigna 0.");
					edad=0;
				}
			}
			//persona=new Persona(nombre,apellido,edad);
			//return persona;
		}catch(IOException e){
			Leer.mostrarEnPantalla("Error al leer en el archivo "+e.getMessage());
			System.exit(1);
		} catch (NullPointerException e) {
			//return null;
		}
		//return persona;
	}

	public Boolean escribir(String nombre, String contraseña ){
		
		try {
			if(nombre!=null){//si el objeto existe lo escribimos
				salida.write(nombre+Separable.getSeparador()+contraseña);
			}
		}catch(IOException e){//controlar el error de escritura
			Leer.mostrarEnPantalla("Error al leer en el archivo "+e.getMessage());
			System.exit(1);
		} catch (NullPointerException e) {//controlar el error de asignación de fichero
	        return false;
	    }
		return true;
	}
	
	public void cerrar(String io){ 
		try{
			if(io.equals("I")){//cerrar el buffer de entrada
				entrada.close();
			}
			if(io.equals("O")){//cerrar el buffer de salida
				salida.close();
			}
		}catch(IOException e){//controlar la excepción
			Leer.mostrarEnPantalla("Error al cerrar el archivo "+e.getMessage());
			System.exit(1);
		}
	}
}
