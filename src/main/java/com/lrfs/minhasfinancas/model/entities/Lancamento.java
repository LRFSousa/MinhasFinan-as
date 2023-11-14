package com.lrfs.minhasfinancas.model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.convert.Jsr310Converters;

import com.lrfs.minhasfinancas.model.enums.Status;
import com.lrfs.minhasfinancas.model.enums.TipoLancamento;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "lancamento", schema = "financas")
@Data
@Builder
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long id;
	
	@Column
	public String descricao;
	
	@Column
	public Integer mes;
	
	@Column
	public Integer ano;
	
	@ManyToOne //sempre referencia a classe atual para a outra que vc quer
	@JoinTable(name = "id_usuario")
	private Usuario usuario;
	
	@Column
	private BigDecimal valor;
	
	@Column(name = "data_cadastro")
	@Convert(converter = Jsr310Converters.DateToLocalDateConverter.class)
	private LocalDate dataCadastro;

	@Column
	@Enumerated(value = EnumType.STRING)
	private TipoLancamento tipo;
	
	@Column
	@Enumerated(value = EnumType.STRING)
	private Status status;

}
