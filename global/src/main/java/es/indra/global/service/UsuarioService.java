package es.indra.global.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.indra.global.model.Usuario;

@Service
public interface UsuarioService {

	public List<Usuario> getAllUsuarios();

	public Usuario validarInicioSesion(String userName, String password);

	public Usuario crearUsuario(Usuario user);

}
