package com.mballen.curso.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mballen.curso.boot.model.Produto;
import com.mballen.curso.boot.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Produto produto) {
		return "/produto/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("produtos", service.buscarTodos());
		return "/produto/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Produto produto, RedirectAttributes attr) {
		service.salvar(produto);
		attr.addFlashAttribute("sucess", "Produto inserido com sucesso.");
		return "redirect:/produtos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) throws Exception {
		model.addAttribute("produto", service.buscarPorId(id));
		return "/produto/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Produto produto, RedirectAttributes attr) throws Exception {
		service.editar(produto);
		attr.addFlashAttribute("sucess", "Produto editado com sucesso.");
		return "redirect:/produtos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) throws Exception {
		service.excluir(id);
		model.addAttribute("sucess", "Produto excluido com sucesso.");
		return "redirect:/produtos/listar";
	}
	
}
