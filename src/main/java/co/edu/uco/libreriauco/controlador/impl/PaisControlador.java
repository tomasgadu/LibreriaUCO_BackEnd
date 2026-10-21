package co.edu.uco.libreriauco.controlador.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.libreriauco.controlador.AbstractRestController;
import co.edu.uco.libreriauco.controlador.respuesta.RespuestaOk;
import co.edu.uco.libreriauco.dto.PaisDTO;
import co.edu.uco.libreriauco.negocio.fachada.PaisFachada;
import co.edu.uco.libreriauco.negocio.fachada.impl.PaisFachadaImpl;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisControlador extends AbstractRestController {

	private PaisFachada fachada = new PaisFachadaImpl();

	@GetMapping("/dummy")
	public PaisDTO obtenerDummy() {
		return new PaisDTO();
	}

	@PostMapping
	public ResponseEntity<RespuestaOk<String>> registrarInformacionNuevoPais(@RequestBody PaisDTO pais) {
		fachada.registrarInformacionNuevoPais(pais);
		RespuestaOk<String> respuesta = RespuestaOk
				.crear("Se ha registrado la información del nuevo país de forma exitosa.");
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RespuestaOk<PaisDTO>> consultarPorId(@PathVariable UUID id) {
		var pais = fachada.consultarPorId(id);
		RespuestaOk<PaisDTO> respuesta = RespuestaOk.crear(pais);
		return ResponseEntity.ok(respuesta);
		// TODOS LOS MENSAJES DEBEN IR EN EL CATALOGO DE MENSAJES
	}

	// ............../api/v1/paises?id=valor&nombre=Colombia
	// ............../api/v1/paises?id=valor
	// ............../api/v1/paises?nombre=Colombia
	// ............../api/v1/paises?nombre=Colombia&id=valor
	// ............../api/v1/paises
	// ............../api/v1/paises?paisResidencia=valor BAD Practice
	// ............../api/v1/paises?pais-Residencia=valor BEST Practice

	@GetMapping
	public ResponseEntity<RespuestaOk<PaisDTO>> consultraPorFiltro(PaisDTO filtro) {
		var paises = fachada.consultarPorFiltro(filtro);
		RespuestaOk<PaisDTO> respuesta = RespuestaOk.crear(paises);
		return ResponseEntity.ok(respuesta);
	}

	@PutMapping("/{id}")
	public ResponseEntity<RespuestaOk<String>> modificarInformacionPaisExistente(@PathVariable UUID id,
			@RequestBody PaisDTO datos) {
		fachada.modificarInformacionPaisExistente(id, datos);
		RespuestaOk<String> respuesta = RespuestaOk
				.crear("Se ha modificado la información del país deseado de forma exitosa.");
		return ResponseEntity.ok(respuesta);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<RespuestaOk<String>> darBajaInformacionPaisExistente(@PathVariable UUID id) {
		fachada.darBajaInformacionPaisExistente(id);
		RespuestaOk<String> respuesta = RespuestaOk
				.crear("Se ha eliminado la información del país deseado de forma exitosa.");
		return ResponseEntity.ok(respuesta);
	}

}

//<protocolo>:// <host>:<puerto>/<recurso>
//http:// localhost: 8800/api/v1/paises
//http:// 127.0.0.1: 8800/api/v1/paises
//http:// 192.168.56.1:8800/api/v1/paises
//http:// MSI:8800/api/v1/paises
