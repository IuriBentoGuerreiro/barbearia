package com.iuri.barbearia.Controller;

import com.iuri.barbearia.dto.AgendamentoRequest;
import com.iuri.barbearia.model.Agendamento;
import com.iuri.barbearia.service.AgendamentoService;
import com.iuri.barbearia.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @Autowired
    public AgendamentoController(AgendamentoService agendamentoRepository, ServicoService servicoService) {
        this.agendamentoService = agendamentoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento salvar(@RequestBody AgendamentoRequest request){
        return agendamentoService.salvar(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Agendamento> listar(){
        return agendamentoService.listar();
    }
}
