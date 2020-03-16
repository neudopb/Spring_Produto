package com.mballen.curso.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mballen.curso.boot.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
