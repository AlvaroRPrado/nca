package com.rowdrigs.ofertahoje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rowdrigs.ofertahoje.model.Produto;
import com.rowdrigs.ofertahoje.repository.Produtos;

@Service
public class CadastroProdutoService {
	
	@Autowired
	private Produtos produtos;

	@Transactional
public void salvar(Produto produto){
	produtos.save(produto);
	
}

}
