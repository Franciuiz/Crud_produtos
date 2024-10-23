package com.example.Crud_produtos.service;


import com.example.Crud_produtos.entity.Produtos;
import com.example.Crud_produtos.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public List<Produtos> create(Produtos produtos){
        produtosRepository.save(produtos);
        return list();
    }

    public List<Produtos> list(){
        Sort s = Sort.by(Sort.Direction.ASC, "id");
        return produtosRepository.findAll(s);
    }

    public Optional<Produtos> list(Long id){
        return produtosRepository.findById(id);
    }

    public List<Produtos> update(Long id, Produtos produtos){
        Produtos produtosUpdated = produtosRepository.findById(id).orElseThrow();
        produtosUpdated.setNome(produtos.getNome());
        produtosUpdated.setDescricao(produtos.getDescricao());
        produtosUpdated.setPreco(produtos.getPreco());
        produtosRepository.save(produtosUpdated);
        return list();
    }

    public List<Produtos> delete(Long id){
        produtosRepository.deleteById(id);
        return list();
    }

}
