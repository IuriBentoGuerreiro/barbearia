package com.iuri.barbearia.model;

import com.iuri.barbearia.dto.AgendamentoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "agendamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cliente")
    private String cliente;
    @Column(name = "data_hora")
    private LocalDateTime dataHora;
    @ManyToMany
    private List<Servico> servicos;

    public static Agendamento converter(AgendamentoRequest agendamentoRequest){
        return Agendamento.builder()
                .cliente(agendamentoRequest.getCliente())
                .dataHora(LocalDateTime.now())
                .servicos(agendamentoRequest.getServicos().stream()
                        .map(Servico::new).toList())
                .build();
    }
}
