package com.gitgames.gitgames.domain.produto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Preço do produto", example = "100.00")
    BigDecimal preco,
    @Schema(description = "Descrição do produto", example = "Jogo de corrida")
    String descricao
    


) {

    
}
