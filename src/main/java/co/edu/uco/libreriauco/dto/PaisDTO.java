package co.edu.uco.libreriauco.dto;
import java.util.UUID;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class PaisDTO {
	
	private UUID id;
	private String nombre;
	
	public PaisDTO() {
	setId(UtilUUID.obtenerUUIDDefecto());
	setNombre(UtilTexto.VACIO);
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
	
	
	
}
