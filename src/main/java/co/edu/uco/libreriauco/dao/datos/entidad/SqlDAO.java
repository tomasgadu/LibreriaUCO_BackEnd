package co.edu.uco.libreriauco.dao.datos.entidad;

import java.sql.Connection;

public abstract class SqlDAO {
	
	private Connection conexion;
	
	protected SqlDAO(Connection conexion) {
		setConexion(conexion);
	}

	private Connection getConexion() {
		return conexion;
	}

	private void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	
	
}
