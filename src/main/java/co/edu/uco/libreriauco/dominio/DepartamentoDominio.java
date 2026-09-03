package co.edu.uco.libreriauco.dominio;
import java.util.UUID;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class DepartamentoDominio {
	
	private UUID id;
	private String nombre;
	private PaisDominio pais;
	
	
	private DepartamentoDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.pais = builder.pais;
	}
	

	public UUID getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public PaisDominio getPais() {
		return pais;
	}


	public static class Builder {
		private UUID id;
		private String nombre;
		private PaisDominio pais;
		
		public Builder() {
			id = UtilUUID.ObtenerUUIDDefecto();
			nombre = UtilTexto.VACIO;
			pais = new PaisDominio.Builder().build();
		}
		
		public Builder id(UUDID id) {
			this.id = UtilUUID.ObtenerValorDefecto(id);
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
			return this;
		}
		
		public Builder pais(PaisDominio pais) {
			this.pais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pais, new PaisDominio.Builder().build());
			return this;
		}
		
		public DepartamentoDominio build() {
			return new DepartamentoDominio(this)
		}
	}
}