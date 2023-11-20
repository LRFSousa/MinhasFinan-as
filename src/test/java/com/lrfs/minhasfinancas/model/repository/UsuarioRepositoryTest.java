package com.lrfs.minhasfinancas.model.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.lrfs.minhasfinancas.model.entities.Usuario;


//teste de integração - precisa de recursos externos a aplicação
//@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
//@ExtendWith(SpringExtension.class)
@DataJpaTest //cria uma instância do BD na memória, usado só para testes
@AutoConfigureTestDatabase(replace = Replace.NONE)//não sobrescreve as configuração no BD
public class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	TestEntityManager entityManager;//configurado apenas para teste
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		//cenário
		Usuario usuario = criarUsuario();
		entityManager.persist(usuario);
		//Ação / execução
	boolean result = repository.existsByEmail("usuario@email.com");
		
		//Verificação
	Assertions.assertThat(result).isFalse();
	
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {
		//cenário
	
		//ação
		boolean result = repository.existsByEmail("usuario@email.com");
		
		//verificação
		Assertions.assertThat(result).isFalse();
	}
	
	
	
	@Test
	public void devePersistirUmUsuarioNaBaseDeDados() {
		//cenário
		Usuario usuario = criarUsuario();
		
		//ação
		Usuario usuarioSalvo = repository.save(usuario);
		
		//verificação
		Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
		
	}
	
	@Test
	public void deveBuscarUmUsuarioPorEmail() {
		//cenário
		Usuario usuario = criarUsuario();
		entityManager.persist(usuario);
		
		//ação
		
		//verificação
		Optional<Usuario> result = repository.findByEmail("email@email.com");
		
		Assertions.assertThat(result.isPresent()).isTrue();
	}
	
	@Test
	public void deveRetornarVazioAoBuscarUsuarioPorEmailQuandoNaoExisteNaBase() {
		//cenário
	
		//ação
		boolean result = repository.existsByEmail("usuario@email.com");
		
		//verificação
		Assertions.assertThat(result).isFalse();
	}
	
	public static Usuario criarUsuario() {
		return Usuario.builder().nome("usuario").email("email@email.com").senha("senha").build();
				
	}
}
