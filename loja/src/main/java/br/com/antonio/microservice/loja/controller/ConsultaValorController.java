package br.com.antonio.microservice.loja.controller;

import br.com.antonio.microservice.loja.client.FornecedorClient;
import br.com.antonio.microservice.loja.dto.ProdutoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/valor")
public class ConsultaValorController {

    private final Logger logger = LoggerFactory.getLogger(ConsultaValorController.class);

    @Autowired
    private FornecedorClient fornecedorClient;

    @GetMapping("/{valor}")
    public ProdutoDto getValor(@PathVariable BigDecimal valor) {
        ProdutoDto nomeProdutoDto = fornecedorClient.consultaValor(valor);
        return nomeProdutoDto;
    }

}
