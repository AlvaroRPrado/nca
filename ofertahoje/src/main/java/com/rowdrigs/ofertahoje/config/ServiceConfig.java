package com.rowdrigs.ofertahoje.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rowdrigs.ofertahoje.service.CadastroProdutoService;

@Configuration
@ComponentScan(basePackageClasses = CadastroProdutoService.class)
public class ServiceConfig {

}
