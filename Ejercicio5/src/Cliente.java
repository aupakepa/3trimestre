
public class Cliente {

	private Integer tipo;
	private Integer cola;

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getCola() {
		return cola;
	}

	public void setCola(Integer cola) {
		this.cola = cola;
	}

	public Cliente(Integer tipo, Integer cola) {
		super();
		this.tipo = tipo;
		this.cola = cola;
	}
	public void atencion() {
		this.tipo--;

	}
	@Override
	public String toString() {
		return "Cliente [tipo=" + tipo + ", cola=" + cola + "]";
	}
}
