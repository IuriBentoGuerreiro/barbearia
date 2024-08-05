package com.iuri.barbearia.service;

import com.iuri.barbearia.dto.ServicoRequest;
import com.iuri.barbearia.model.Servico;
import com.iuri.barbearia.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public Servico salvar(ServicoRequest request){
        return servicoRepository.save(Servico.converter(request));
    }

    public List<Servico> listar(){
        return servicoRepository.findAll();
    }

    public List<Servico> listarPorId(List<Integer> id){
        return servicoRepository.findAllById(id);
    }
}
