package com.rowdrigs.ofertahoje.tymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.rowdrigs.ofertahoje.tymeleaf.processor.ClassForErrorAttributeTagProcessor;
import com.rowdrigs.ofertahoje.tymeleaf.processor.MessageElementTagProcessor;

public class OfertahojeDialect extends AbstractProcessorDialect {

	public OfertahojeDialect() {
		super("Rowdrigs Ofertahoje", "ofertahoje", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		return processadores;
	}


}