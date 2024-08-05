package com.iuri.barbearia.service;

import com.iuri.barbearia.dto.AgendamentoRequest;
import com.iuri.barbearia.model.Agendamento;
import com.iuri.barbearia.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ServicoService servicoService;

    @Autowired
    public AgendamentoService(AgendamentoRepository agendamentoRepository, ServicoService servicoService) {
        this.agendamentoRepository = agendamentoRepository;
        this.servicoService = servicoService;
    }

    public Agendamento salvar(AgendamentoRequest request){
        return agendamentoRepository.save( Agendamento.builder()
                .cliente(request.getCliente())
                .dataHora(LocalDateTime.now())
                .servicos(servicoService.listarPorId(request.getServicos()))
                .build());
    }

    public List<Agendamento> listar(){
        return agendamentoRepository.findAll();
    }
}
