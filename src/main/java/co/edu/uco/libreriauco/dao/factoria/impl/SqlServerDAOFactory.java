package co.edu.uco.libreriauco.dao.factoria.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCODatosException;

public class SqlServerDAOFactory extends DAOFactory{

	private static final String URL = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName=LibreriaUCO;"
			+ "integratedSecurity=true;"
			+ "encrypt=true;"
			+ "trustServerCertificate=true;";
	
	@Override
	protected void abrirConexion() {
		try {
			Connection conexion = DriverManager.getConnection(URL);
			setConexion(conexion);
		} catch (SQLException excepcion) {
			var mensajeUsuario = "No fue posible conectarse con la fuente de información. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación";
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de conectarse con la fuente de información. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación";
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		return new PaisSqlServerDAO(getConexion());
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		return new DepartamentoSqlServerDAO(getConexion());
	}

}