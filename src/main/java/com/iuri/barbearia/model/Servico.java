package com.iuri.barbearia.model;

import com.iuri.barbearia.dto.ServicoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "servico")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private BigDecimal preco;

    public Servico(Integer id){
        this.id = id;
    }

    public static Servico converter(ServicoRequest servicoRequest){
        return Servico.builder()
                .nome(servicoRequest.getNome())
                .preco(servicoRequest.getPreco())
                .build();
    }
}
