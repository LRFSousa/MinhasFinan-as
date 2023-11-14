package com.lrfs.minhasfinancas.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "usuario", schema = "financas")
@Data
@Builder
public class Usuario {

	@Id
	@Column(name = "id")//não é necessário colocar caso os nomes sejam o mesmo, é só pra referenciar a tabela no BD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String senha;
	
	
	
}
