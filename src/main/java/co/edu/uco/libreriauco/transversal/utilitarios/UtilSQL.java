package co.edu.uco.libreriauco.transversal.utilitarios;

public class UtilSQL {
	
	private UtilSQL () {
		
	}
	
	public static boolean conexionEstaAbierta() {
		
	}
	
	public static boolean conexionEstaVacia(Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}

}
