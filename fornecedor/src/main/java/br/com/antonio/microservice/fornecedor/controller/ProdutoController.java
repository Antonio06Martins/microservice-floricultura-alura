package br.com.antonio.microservice.fornecedor.controller;

import br.com.antonio.microservice.fornecedor.model.Produto;
import br.com.antonio.microservice.fornecedor.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{estado}")
    public List<Produto> getProdutosPorEstado(@PathVariable("estado") String estado) {
        return produtoService.getProdutosPorEstado(estado);
    }
}
