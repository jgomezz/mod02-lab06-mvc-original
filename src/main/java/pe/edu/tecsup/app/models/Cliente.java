package pe.edu.tecsup.app.models;

public class Cliente {

	private String codigo;
	private String nombres;
	private String paterno;
	private String materno;



	// Generar los métodos set y get
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	/**
	 *  Funcionalidad basico
	 * @return
	 */
	public String getNombreCompleto() {
		return this.nombres + " " + this.paterno + " " + this.materno;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombres=" + nombres + ", paterno=" + paterno + ", materno=" + materno
				+ "]";
	}	
	
	
}

