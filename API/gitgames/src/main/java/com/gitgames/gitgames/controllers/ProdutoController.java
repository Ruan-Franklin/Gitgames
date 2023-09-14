package com.gitgames.gitgames.controllers;

import com.gitgames.gitgames.domain.produto.Produto;
import com.gitgames.gitgames.domain.produto.RequestProduto;
import com.gitgames.gitgames.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    @GetMapping
    public ResponseEntity getAllProdutos(){
        var todosProdutos = produtoRepository.findAll();
        return ResponseEntity.ok(todosProdutos);
    }
    @PostMapping
    public ResponseEntity cadastrarProduto(@RequestBody @Valid RequestProduto dado){
        Produto novoProduto= new Produto(dado);
        produtoRepository.save(novoProduto);
        return ResponseEntity.ok().build();

    }


    
    
}
