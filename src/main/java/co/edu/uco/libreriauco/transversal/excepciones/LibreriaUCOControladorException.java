package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOControladorException extends LibreriaUCOExcepcion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2781462033546993220L;

	protected LibreriaUCOControladorException(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(capa.CONTROLADOR, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriaUCOControladorException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
		
	}
}
