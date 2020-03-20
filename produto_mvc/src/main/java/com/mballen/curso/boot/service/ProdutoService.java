package com.mballen.curso.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mballen.curso.boot.model.Produto;
import com.mballen.curso.boot.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public void salvar(Produto produto) {
		this.produtoRepository.save(produto);
	}
	
	public void editar(Produto produtoASerSalvo) throws Exception {
		Produto produtoBuscado = this.buscarPorId(produtoASerSalvo.getId());
		BeanUtils.copyProperties(produtoASerSalvo, produtoBuscado, "id");
		this.produtoRepository.save(produtoBuscado);
	}
	
	public void excluir(Long id) throws Exception {
		Produto produtoBuscado = this.buscarPorId(id);
		this.produtoRepository.delete(produtoBuscado);
	}
	
	public Produto buscarPorId(Long id) throws Exception {
		Optional<Produto> produtoBuscado = this.produtoRepository.findById(id);
		if(!produtoBuscado.isPresent()) {
			throw new Exception("Produto não encontrado");
		}
		return produtoBuscado.get();
	}
	
	public List<Produto> buscarTodos(){
		return this.produtoRepository.findAll();
	}
}
