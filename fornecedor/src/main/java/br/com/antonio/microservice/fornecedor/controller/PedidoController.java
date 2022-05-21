package br.com.antonio.microservice.fornecedor.controller;

import br.com.antonio.microservice.fornecedor.dto.ItemDoPedidoDTO;
import br.com.antonio.microservice.fornecedor.model.Pedido;
import br.com.antonio.microservice.fornecedor.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
        logger.info("Pedido recebido");
        return pedidoService.realizaPedido(produtos);
    }

    @GetMapping("/{id}")
    public Pedido getPedidoPorId(@PathVariable Long id) {
        return pedidoService.getPedidoPorId(id);
    }
}
