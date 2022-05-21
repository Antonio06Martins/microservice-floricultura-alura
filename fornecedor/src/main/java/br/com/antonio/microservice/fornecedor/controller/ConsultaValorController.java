package br.com.antonio.microservice.fornecedor.controller;

import br.com.antonio.microservice.fornecedor.model.Produto;
import br.com.antonio.microservice.fornecedor.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/valor")
public class ConsultaValorController {

    private final Logger logger = LoggerFactory.getLogger(ConsultaValorController.class);

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/{valor}")
    public Produto getValorProduto(@PathVariable BigDecimal valor) {
        Produto produtoValor = produtoRepository.findByPreco(valor);
        logger.info("Produto para esse valor é :{}", produtoValor.getNome());
        return produtoValor;
    }
}
