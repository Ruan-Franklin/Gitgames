package com.gitgames.gitgames.controllers;

import com.gitgames.gitgames.domain.produto.Produto;
import com.gitgames.gitgames.domain.produto.RequestProduto;
import com.gitgames.gitgames.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @PutMapping
    @Transactional
    public ResponseEntity atualizarProduto(@RequestBody @Valid RequestProduto dado) throws Exception {
        Optional<Produto> produtoOptional = produtoRepository.findById(dado.id());
        if(produtoOptional.isPresent()){
            Produto produto = produtoOptional.get();
            produto.setNome(dado.nome());
            produto.setDescricao(dado.descricao());
            produto.setPreco(dado.preco());
            produto.setPlataforma(dado.plataforma());
            produto.setEstoque(dado.estoque());
            return ResponseEntity.ok(produto);
        }
        else{
            throw new Exception("Produto não encontrado");
        }
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarProduto(@PathVariable Integer id){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            produto.setAtivo(false);
            return  ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }



    
    
}
