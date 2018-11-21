package es.indra.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.indra.global.model.Usuario;
import es.indra.global.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getAllUsuarios() {

		List<Usuario> todosLosUsuarios = this.usuarioService.getAllUsuarios();

		ResponseEntity<List<Usuario>> response = new ResponseEntity<List<Usuario>>(todosLosUsuarios, HttpStatus.OK);

		return response;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario/{userName}/{password}", method = RequestMethod.GET)
	public ResponseEntity<Usuario>

			validacion(@PathVariable("userName") String userName, @PathVariable("password") String password) {

		Usuario u = this.usuarioService.validarInicioSesion(userName, password);
		if (u != null) {
			ResponseEntity<Usuario> response = new ResponseEntity<Usuario>(u, HttpStatus.OK);
			return response;
		} else {
			return null;

		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ResponseEntity<Void> crearUsuario(@RequestBody Usuario user) {

		Usuario u = this.usuarioService.crearUsuario(user);

		System.out.println(user);

		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

}
