package org.ucm.tp.pojos;


public final class Profesor{
	private String nombre;
	private String apellidos;
	private String plaza;
	public final String getNombre() {
		return nombre;
	}
	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public final String getApellidos() {
		return apellidos;
	}
	public final void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public final String getPlaza() {
		return plaza;
	}
	public final void setPlaza(String plaza) {
		this.plaza = plaza;
	}
	public Profesor() {
		this.nombre = "John";
		this.apellidos = "Doe";
		this.plaza = "Unknown";
	};
	public Profesor(String nombre, String apellidos, String plaza) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.plaza = plaza;
	}
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((plaza == null) ? 0 : plaza.hashCode());
		return result;
	}
	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (plaza == null) {
			if (other.plaza != null)
				return false;
		} else if (!plaza.equals(other.plaza))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", apellidos=" + apellidos + ", plaza=" + plaza + "]";
	}

}