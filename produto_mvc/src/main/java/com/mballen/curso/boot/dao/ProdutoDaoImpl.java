package com.mballen.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.mballen.curso.boot.model.Produto;

@Repository
public class ProdutoDaoImpl extends AbstractDao<Produto, Long> implements ProdutoDao {
	
}
