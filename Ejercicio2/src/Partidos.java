
public class Partidos implements Comparable<Partidos> {

	private String nombre;

	private Integer votos;
	private Integer escanos;
	private int reparto;

	public Partidos(String nombre, Integer votos) {
		super();
		this.nombre = nombre;
		this.votos = votos;
		escanos = 0;
		this.reparto = votos;
	}

	@Override
	public String toString() {
		return "Partidos [Nombre=" + nombre + ", votos=" + votos + ", escanos=" + escanos + ", reparto=" + reparto
				+ "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getVotos() {
		return votos;
	}

	public void setVotos(Integer votos) {
		this.votos = votos;
	}

	public Integer getEscanos() {
		return escanos;
	}

	public void setEscanos(Integer escanos) {
		this.escanos = escanos;
	}

	public int getReparto() {
		return reparto;
	}

	public void setReparto(int reparto) {
		this.reparto = reparto;
	}

	@Override
	public int compareTo(Partidos arg0) {
		// TODO Auto-generated method stub
		return -this.reparto + arg0.getReparto();
	}

	public void asignarEscanos() {
		escanos++;
		reparto = this.votos / (escanos + 1);
	}

/*public boolean equals(Partidos partido) {
		if (this.nombre == partido.getNombre()) {
			return true;
		} else {
			return false;
		}

	}*/

}
