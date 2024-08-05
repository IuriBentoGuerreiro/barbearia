package com.iuri.barbearia.Controller;

import com.iuri.barbearia.dto.ServicoRequest;
import com.iuri.barbearia.model.Servico;
import com.iuri.barbearia.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    private final ServicoService servicoService;

    @Autowired
    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico salvar(@RequestBody ServicoRequest request){
        return servicoService.salvar(request);
    }
}
