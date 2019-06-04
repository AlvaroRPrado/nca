package com.rowdrigs.ofertahoje.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rowdrigs.ofertahoje.model.Produto;

@Repository
public interface Produtos extends JpaRepository<Produto,  Long> {
	
	public Optional<Produto> findBySkuIgnoreCase(String sku);
	
}
