package org.ucm.tp.pojos;

import java.util.ArrayList;
import java.util.List;


public final class Clase {

	private String clase;
	private String grupo;
	private int curso;
	private List<String> aulas;
	private List<Profesor> profesores;
	
	public Clase() {
		super();
		this.clase = "?";
		this.grupo = "?";
		this.curso = -1;
		this.aulas = new ArrayList<String>();
		this.profesores = new ArrayList<Profesor>();
	}
	public Clase(String clase, String grupo, int curso, List<String> aulas, List<Profesor> profesores) {
		super();
		this.clase = clase;
		this.grupo = grupo;
		this.curso = curso;
		this.aulas = aulas;
		this.profesores = profesores;
	}
	public final String getClase() {
		return clase;
	}
	public final void setClase(String clase) {
		this.clase = clase;
	}
	public final String getGrupo() {
		return grupo;
	}
	public final void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public final int getCurso() {
		return curso;
	}
	public final void setCurso(int curso) {
		this.curso = curso;
	}
	public final List<String> getAulas() {
		return aulas;
	}
	public final void setAulas(ArrayList<String> aulas) {
		this.aulas = aulas;
	}
	public final List<Profesor> getProfesores() {
		return profesores;
	}
	public final void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aulas == null) ? 0 : aulas.hashCode());
		result = prime * result + ((clase == null) ? 0 : clase.hashCode());
		result = prime * result + curso;
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((profesores == null) ? 0 : profesores.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clase other = (Clase) obj;
		if (aulas == null) {
			if (other.aulas != null)
				return false;
		} else if (!aulas.equals(other.aulas))
			return false;
		if (clase == null) {
			if (other.clase != null)
				return false;
		} else if (!clase.equals(other.clase))
			return false;
		if (curso != other.curso)
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (profesores == null) {
			if (other.profesores != null)
				return false;
		} else if (!profesores.equals(other.profesores))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Clase [clase=" + clase + ", grupo=" + grupo + ", curso=" + curso + ", aulas=" + aulas + ", profesores="
				+ profesores + "]";
	}
	
	
}
