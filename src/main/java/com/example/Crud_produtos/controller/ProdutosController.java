package com.example.Crud_produtos.controller;

import com.example.Crud_produtos.entity.Produtos;
import com.example.Crud_produtos.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @PostMapping
    List<Produtos> create(@RequestBody Produtos produtos){
        return produtosService.create(produtos);
    }

    @GetMapping
    List<Produtos> list(){
        return produtosService.list();
    }

    @GetMapping("{id}")
    Optional<Produtos> list(@PathVariable ("id") Long id){
        return produtosService.list(id);
    }

    @PutMapping("{id}")
    List<Produtos> update(@PathVariable("id") Long id, @RequestBody Produtos produtos){
        return produtosService.update(id, produtos);
    }

    @DeleteMapping("{id}")
    List<Produtos> delete(@PathVariable("id") Long id){
        return produtosService.delete(id);
    }
}
