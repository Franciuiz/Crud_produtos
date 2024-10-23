package com.example.Crud_produtos.repository;


import com.example.Crud_produtos.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}
