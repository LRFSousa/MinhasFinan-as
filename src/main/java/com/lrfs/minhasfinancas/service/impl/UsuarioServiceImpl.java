package com.lrfs.minhasfinancas.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lrfs.minhasfinancas.exception.ErroAutenticacao;
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
		Optional<Usuario> usuario = repository.findByEmail(email);
		if(!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado para o email informado.");
		}
		if(!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha inválida.");
		}
		return usuario.get();
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
