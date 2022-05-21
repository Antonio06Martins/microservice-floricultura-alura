package br.com.antonio.microservice.loja.controller;

import br.com.antonio.microservice.loja.dto.CompraDto;
import br.com.antonio.microservice.loja.model.Compra;
import br.com.antonio.microservice.loja.service.CompraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private final Logger logger = LoggerFactory.getLogger(CompraController.class);

    @Autowired
    private CompraService compraService;

    @PostMapping
    public Compra realizaCompra(@RequestBody CompraDto compraDto) {
        logger.info("Recebendo compra {}", compraDto);
        return compraService.realizaCompra(compraDto);

    }
}
