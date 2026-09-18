package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOEntidadException extends LibreriaUCOExcepcion {


	private static final long serialVersionUID = 2781462033546993220L;

	private LibreriaUCOEntidadException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.ENTIDAD, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
}
