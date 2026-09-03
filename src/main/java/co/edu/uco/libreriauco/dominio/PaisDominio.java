package co.edu.uco.libreriauco.dominio;
import java.util.UUID;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class PaisDominio {
	
	private UUID id;
	private String nombre;
	
	
	private PaisDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
	}
	
	
	public UUID getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public static class Builder {
		private UUID id;
		private String nombre;
		
		public Builder() {
			id = UtilUUID.ObtenerUUIDDefecto();
			nombre = UtilTexto.VACIO;
		}
		
		public Builder id(UUDID id) {
			this.id = UtilUUID.ObtenerValorDefecto(id);
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
			return this;
		}
		
		public PaisDominio build() {
			return new PaisDominio(this);
		}
		
	}
}
