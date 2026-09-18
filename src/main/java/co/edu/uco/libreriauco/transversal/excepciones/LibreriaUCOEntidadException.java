package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOEntidadException extends LibreriaUCOExcepcion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2781462033546993220L;

	protected LibreriaUCOEntidadException(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(capa.ENTITY, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}
	
}
