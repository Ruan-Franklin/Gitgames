package com.gitgames.gitgames.domain.produto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "produto")
@Entity(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String plataforma;
    private Integer estoque;
    private Boolean ativo;

    public Produto(RequestProduto requestProduto){
        this.nome = requestProduto.nome();
        this.descricao = requestProduto.descricao();
        this.preco = requestProduto.preco();
        this.plataforma = requestProduto.plataforma();
        this.estoque = requestProduto.estoque();
        this.ativo = true;
    }


}
