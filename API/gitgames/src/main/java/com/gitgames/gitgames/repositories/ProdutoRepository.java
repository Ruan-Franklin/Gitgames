package com.gitgames.gitgames.repositories;

import com.gitgames.gitgames.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository  extends JpaRepository<Produto, Integer>{
    List<Produto> findByAtivoTrue();
    
}
