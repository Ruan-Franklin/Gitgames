package com.gitgames.gitgames.domain.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RequestProduto(
    Integer id,
    @NotBlank 
    String nome,
    String plataforma,
    @NotNull 
    Integer estoque,
    @NotNull
    BigDecimal preco,
    String descricao
    


) {

    
}
