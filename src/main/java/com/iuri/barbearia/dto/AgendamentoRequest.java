package com.iuri.barbearia.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AgendamentoRequest {

    private String cliente;
    //private LocalDateTime dataHora;
    private List<Integer> servicos;
}
