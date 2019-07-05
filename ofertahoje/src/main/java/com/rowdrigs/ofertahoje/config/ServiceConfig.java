package com.rowdrigs.ofertahoje.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rowdrigs.ofertahoje.service.CadastroProdutoService;
import com.rowdrigs.ofertahoje.storage.FotoStorage;
import com.rowdrigs.ofertahoje.storage.local.FotoStorageLocal;

@Configuration
@ComponentScan(basePackageClasses = CadastroProdutoService.class)
public class ServiceConfig {
	
	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}

}
