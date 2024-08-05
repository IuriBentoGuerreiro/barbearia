package com.iuri.barbearia.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class servicoRequest {

    private String nome;
    private BigDecimal preco;
}
