package com.moises.APIconceito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moises.APIconceito.domain.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
