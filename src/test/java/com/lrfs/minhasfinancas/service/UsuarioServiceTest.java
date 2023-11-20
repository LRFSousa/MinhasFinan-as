package com.lrfs.minhasfinancas.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.lrfs.minhasfinancas.model.entities.Usuario;
import com.lrfs.minhasfinancas.model.repository.UsuarioRepository;

@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;

	@Test
	public void deveValidarEmail() {
		
		//cenário
		repository.deleteAll();
		
		//ação
		service.validarEmail("email@email.com");
	}
	
	@Test()
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		//cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("email@email.com").build();
		repository.save(usuario);
		
		//ação
		service.validarEmail("email@email.com");
	}
}
