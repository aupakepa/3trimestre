
public class Autor implements Comentable {
	private String nombre;
	private String email;
	private Character sexo;
	private String biografia;
	
	public Autor(String nombre, String email, char sexo) {
		this.nombre = nombre;
		this.email = email;
		this.sexo = sexo;
		this.biografia=null;
	}
	
	public Autor(String nombre, String email, String sexo) {
		this.nombre = nombre;
		this.email = email;
		this.sexo = sexo.charAt(0);
		this.biografia=null;
	}
	
	public String cadenaAutor(){
		return "Autor[nombre = " + nombre + ", email = " + email + ", sexo = "+ sexo + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public char getSexo() {
		return sexo;
	}

	@Override
	public void comentar(String texto) {
		// TODO Auto-generated method stub
		this.biografia=texto;
	}

	@Override
	public String comentario() {
		// TODO Auto-generated method stub
		return "Nombre: "+nombre+"\n Biografia:" +biografia;
	}
	
}
