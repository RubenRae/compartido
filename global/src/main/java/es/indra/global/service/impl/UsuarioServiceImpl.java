package es.indra.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.indra.global.model.Usuario;
import es.indra.global.repository.UsuarioRepository;
import es.indra.global.service.UsuarioService;

@Component
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> getAllUsuarios() {

		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario validarInicioSesion(String userName, String password) {

		return this.usuarioRepository.getUsuarioByuserNameAndPassword(userName, password);
	}

	@Override
	public Usuario crearUsuario(Usuario user) {

		return this.usuarioRepository.save(user);
	}

}
