package com.lrfs.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrfs.minhasfinancas.model.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
	boolean existsByEmail(String email);

}

