package com.rowdrigs.ofertahoje.controller.converter;

import org.springframework.core.convert.converter.Converter;

import com.rowdrigs.ofertahoje.model.Categoria;

public class CategoriaConverter implements Converter<String, Categoria>{

	@Override
	public Categoria convert(String codigo) {
		
		if(codigo != null && !codigo.trim().equals("")){
		Categoria categoria = new Categoria();
		categoria.setCodigo(Long.valueOf(codigo));
		return categoria;
		}
		return null;
	}

}
