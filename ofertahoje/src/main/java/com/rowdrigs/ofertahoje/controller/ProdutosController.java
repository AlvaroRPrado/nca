package com.rowdrigs.ofertahoje.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rowdrigs.ofertahoje.model.Produto;
import com.rowdrigs.ofertahoje.model.Origem;
import com.rowdrigs.ofertahoje.repository.Categorias;
import com.rowdrigs.ofertahoje.service.CadastroProdutoService;

@Controller
public class ProdutosController {
	
	@Autowired
	private Categorias categorias;
	
	@Autowired
	private CadastroProdutoService cadastroProdutoService;

	@RequestMapping("/produtos/novo")
	public ModelAndView novo(Produto produto) {
		ModelAndView mv = new ModelAndView("produto/CadastroProduto");
		mv.addObject("categorias", categorias.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}
	
	@RequestMapping(value = "/produtos/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Produto produto, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(produto);
		}
		
		// Salvar no banco de dados...
		cadastroProdutoService.salvar(produto);
		attributes.addFlashAttribute("mensagem", "Produto salva com sucesso!");
		
			return new ModelAndView("redirect:/produtos/novo");
	}
	
	
}