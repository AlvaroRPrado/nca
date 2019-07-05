package com.rowdrigs.ofertahoje.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rowdrigs.ofertahoje.exception.NomeCategoriaJaCadastradoException;

@RestControllerAdvice
public class ControllerAdviceExceptionHandler {
	
	@ExceptionHandler(NomeCategoriaJaCadastradoException.class)
	public ResponseEntity<String> handleNomeCategoriaJaCadastradoException(NomeCategoriaJaCadastradoException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}
