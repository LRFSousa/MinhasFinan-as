package com.lrfs.minhasfinancas.service;

import java.util.Optional;

import com.lrfs.minhasfinancas.model.entities.Usuario;

public interface UsuarioService {

	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	void validarEmail(String email);
	
	
	
}
