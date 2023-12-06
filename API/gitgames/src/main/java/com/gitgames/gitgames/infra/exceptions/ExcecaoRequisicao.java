package com.gitgames.gitgames.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcecaoRequisicao {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity <ExcecaoDto> threat404(){
        ExcecaoDto resposta = new ExcecaoDto("Dado não encontrado com o id informado", 404);
        return ResponseEntity.badRequest().body(resposta);
    }

}
