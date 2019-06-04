package com.rowdrigs.ofertahoje.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rowdrigs.ofertahoje.model.Categoria;

@Repository
public interface Categorias extends JpaRepository<Categoria, Long> {

	 public Optional <Categoria> findByNomeIgnoreCase(String nome);
	
}
