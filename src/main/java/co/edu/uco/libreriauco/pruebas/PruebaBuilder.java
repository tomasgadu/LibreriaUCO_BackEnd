package co.edu.uco.libreriauco.pruebas;

import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PruebaBuilder {
	
	public static void main(String[] args) {
		PaisDominio dominioPaisUno = new PaisDominio.Builder().build();
		PaisDominio dominioConId = new PaisDominio.Builder().id(UtilUUID.generar()).build();
		PaisDominio dominioConNombre = new PaisDominio.Builder().nombre("C").build();
		PaisDominio dominioConCompleto = new PaisDominio.Builder()
												.nombre("C")
												.id(UtilUUID.generar())
												.build();
	}

}
