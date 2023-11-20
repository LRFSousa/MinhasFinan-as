package com.lrfs.minhasfinancas.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.lrfs.minhasfinancas.model.entities.Usuario;


//teste de integração - precisa de recursos externos a aplicação
//@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
//@ExtendWith(SpringExtension.class)
public class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		//cenário
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").senha("senha").build();
		repository.save(usuario);
		//Ação / execução
	boolean result = repository.existsByEmail("usuario@email.com");
		
		//Verificação
	Assertions.assertThat(result).isTrue();
	
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {
		//cenário
		repository.deleteAll();
		
		//ação
		boolean result = repository.existsByEmail("usuario@email.com");
		
		//verificação
		Assertions.assertThat(result).isFalse();
	}
}
