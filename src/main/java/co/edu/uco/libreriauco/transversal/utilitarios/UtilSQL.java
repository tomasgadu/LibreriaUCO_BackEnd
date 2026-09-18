package co.edu.uco.libreriauco.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOTransversalException;

public class UtilSQL {

	private UtilSQL() {

	}

	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			return (!conexionEstaVacia(conexion) && !conexion.isClosed());
		} catch (SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);

		} catch (Exception exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);
		}
	}
	
	public static void asegurarConexionAbierta(Connection conexion) {
		if(!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = "Mensaje que indique en términos de usuario que no es posible continuar porque la conexión no está abierta";
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}
	}


	public static void iniciarTransaccion(Connection conexion) {

		if (transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}

		// TAREA QUE SE TENIA DE COMO INICIAR LA TRANSACCION

	}

	public static void confirmarTransaccion(Connection conexion) {

		if (!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible confirmar una transacción que no fue iniciada";
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}

		// TAREA QUE SE TENIA DE COMO CONFIRMAR LA TRANSACCION

	}

	public static void cancelarTransaccion(Connection conexion) {

		if (!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible cancelar una transacción que no fue iniciada";
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}

		// TAREA QUE SE TENIA DE COMO CANCELAR LA TRANSACCION

	}

	public static void cerrarConexion(Connection conexion) {

		if (!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible cerrar una conexion que no está abierta";
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}

		// TAREA QUE SE TENIA DE COMO CERRAR LA CONEXION

	}

	public static boolean transaccionEstaIniciada(Connection conexion) {
		try {
			return conexionEstaAbierta(conexion) && !conexion.getAutoCommit();
		} catch (SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);

		} catch (Exception exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);
		}

	}

	public static boolean conexionEstaVacia(Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}

}
