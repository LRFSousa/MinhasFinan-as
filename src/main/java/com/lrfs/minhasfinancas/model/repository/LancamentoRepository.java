package com.lrfs.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lrfs.minhasfinancas.model.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
