package com.rowdrigs.ofertahoje.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rowdrigs.ofertahoje.exception.NomeCategoriaJaCadastradoException;
import com.rowdrigs.ofertahoje.model.Categoria;
import com.rowdrigs.ofertahoje.repository.Categorias;

@Service
public class CadastroCategoriaService {

	@Autowired
	private Categorias categorias;
	
	@Transactional
	public Categoria salvar(Categoria categoria) {
		Optional<Categoria> categoriaOptional = categorias.findByNomeIgnoreCase(categoria.getNome());
		if( categoriaOptional.isPresent()){
			throw new NomeCategoriaJaCadastradoException("Nome do categoria ja cadastrado!");
		}
		return categorias.saveAndFlush(categoria);
	}
	
}	


