package co.edu.uco.libreriauco.entidad;
import java.util.UUID;

import co.edu.uco.libreriauco.dto.DepartamentoDTO;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class CiudadEntidad {
	
	private UUID id;
	private String nombre;
	private DepartamentoDTO departamento;
	
	
	public CiudadEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIO);
		setDepartamento(new DepartamentoDTO());
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
	}
	
	public DepartamentoDTO getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(departamento, new DepartamentoDTO());
	}
}
