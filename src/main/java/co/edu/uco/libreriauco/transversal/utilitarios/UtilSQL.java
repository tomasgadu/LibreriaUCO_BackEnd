package co.edu.uco.libreriauco.transversal.utilitarios;

import java.sql.Connection;

public class UtilSQL {
	
	private UtilSQL () {
		
	}
	
	public static boolean conexionEstaAbierta() {
		try {
			if (!conexionEstaVacia(conexion) && !conexion.isClosed()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLExection e) {
			
		}
			
		}
		
	
	public static boolean conexionEstaVacia(Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}

}
