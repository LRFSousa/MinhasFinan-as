package com.lrfs.minhasfinancas.service.impl;

import org.springframework.stereotype.Service;

import com.lrfs.minhasfinancas.exception.RegraNegocioException;
import com.lrfs.minhasfinancas.model.entities.Usuario;
import com.lrfs.minhasfinancas.model.repository.UsuarioRepository;
import com.lrfs.minhasfinancas.service.UsuarioService;

import jakarta.transaction.Transactional;

@Service //cria uma instância e um container para injetar em outras classes
public class UsuarioServiceImpl implements UsuarioService{
	
	
	private UsuarioRepository repository;
	
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
		
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um cadastro com esse email.");
			
		}
	}

	

}
