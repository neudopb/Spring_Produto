package com.mballen.curso.boot.dao;

import java.util.List;

import com.mballen.curso.boot.model.Produto;

public interface ProdutoDao {
	
	void save(Produto produto);
	
	void update(Produto produto);
	
	void delete(Long id);
	
	Produto findById(Long id);
	
	List<Produto> findAll();
}
