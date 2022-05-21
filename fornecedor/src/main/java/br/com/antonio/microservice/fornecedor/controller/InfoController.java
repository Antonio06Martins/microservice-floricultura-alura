package br.com.antonio.microservice.fornecedor.controller;

import br.com.antonio.microservice.fornecedor.model.InfoFornecedor;
import br.com.antonio.microservice.fornecedor.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    private final Logger logger = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    private InfoService infoService;

    @GetMapping("/{estado}")
    public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
        logger.info("Recebido pedido de informações do fornecedor de {}", estado);
        return infoService.getInfoPorEstado(estado);
    }
}
