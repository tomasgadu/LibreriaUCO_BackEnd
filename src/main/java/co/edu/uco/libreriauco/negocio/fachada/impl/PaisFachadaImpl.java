package co.edu.uco.libreriauco.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dto.PaisDTO;
import co.edu.uco.libreriauco.negocio.fachada.PaisFachada;
import co.edu.uco.libreriauco.negocio.negocio.PaisNegocio;
import co.edu.uco.libreriauco.negocio.negocio.impl.PaisNegocioImpl;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOFachadaException;

public class PaisFachadaImpl implements PaisFachada {

	private DAOFactory daoFactory;
	private PaisNegocio paisNegocio;

	public PaisFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		paisNegocio = new PaisNegocioImpl(daoFactory);
	}

	@Override
	public void registrarInformacionNuevoPais(PaisDTO datos) {
		daoFactory.iniciarTransaccion();

		try {
			var paisDominio = new paisDTOAssembler.getInstance().convertirADominio(datos);
			paisNegocio.registrarInformacionNuevoPais(null);
			daoFactory.confirmarTransaccion();
		} catch (LibreriaUCOExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();

			var mensajeUsuario = "Se ha presentado un problema inesperado tratando registrar la información del nuevo país deseado. Por favor intente de nuevo y si el problema persiste, contacte al administradopr de la aplicación";
			throw LibreriaUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}

	}

	@Override
	public void modificarInformacionPaisExistente(UUID id, PaisDTO datos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void darBajaInformacionPaisExistente(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PaisDTO> consultraPorFiltro(PaisDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDTO> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisDTO consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
