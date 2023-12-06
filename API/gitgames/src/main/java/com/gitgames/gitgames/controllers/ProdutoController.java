package com.gitgames.gitgames.controllers;

import com.gitgames.gitgames.domain.produto.Produto;
import com.gitgames.gitgames.domain.produto.RequestProduto;
import com.gitgames.gitgames.domain.produto.RequestProdutoPost;
import com.gitgames.gitgames.repositories.ProdutoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
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
    @Operation(summary = "Obter todos os produtos", description = "Retorna uma lista de todos os produtos cadastrados.")
    @GetMapping
    public ResponseEntity getAllProdutos(){
        var todosProdutos = produtoRepository.findAll();
        return ResponseEntity.ok(todosProdutos);
    }
    @Operation(summary = "Obter produto", description = "Retorna um produto cadastrado.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Produto encontrado"),
                    @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity getProduto(@Parameter( name = "id", description = "ID do produto", example = "1", required = true)@PathVariable Integer id){
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if(produtoOptional.isPresent()){
            Produto produto = produtoOptional.get();
            return ResponseEntity.ok(produto);
        }
        else{
            throw new EntityNotFoundException();
        }
    }
    @Operation(summary = "Cadastrar produto", description = "Cadastra um novo produto.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Erro na requisição"),
            }
    )
    @PostMapping
    public ResponseEntity cadastrarProduto(@Parameter(description = "Os detalhes do produto a ser cadastrado",
                                           content = @Content(mediaType = "application/json", schema = @Schema(implementation = RequestProduto.class)),
    required = true) @RequestBody @Valid RequestProdutoPost dado){
        Produto novoProduto= new Produto(dado);
        produtoRepository.save(novoProduto);
        return ResponseEntity.created(null).build();
    }
    @Operation(summary = "Atualizar produto", description = "Atualiza um produto cadastrado.")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarProduto(@Parameter( name = "id", description = "ID do produto", example = "1", required = true)@PathVariable Integer id, @RequestBody @Valid RequestProduto dado) throws Exception {
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
            throw new EntityNotFoundException();
        }
    }
    @Operation(summary = "Deletar produto", description = "Deleta um produto cadastrado.")
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
            throw new EntityNotFoundException();
        }

    }



    
    
}
