package com.gitgames.gitgames.infra.exceptions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ExcecaoDto {
    String mensagem;
    Integer status;
    public ExcecaoDto(String mensagem, Integer status){
        this.mensagem = mensagem;
        this.status = status;
    }

}
