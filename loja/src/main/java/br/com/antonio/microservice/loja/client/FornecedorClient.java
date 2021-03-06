package br.com.antonio.microservice.loja.client;

import br.com.antonio.microservice.loja.dto.InfoFornecedorDto;
import br.com.antonio.microservice.loja.dto.InfoPedidoDto;
import br.com.antonio.microservice.loja.dto.ItemDaCompraDto;
import br.com.antonio.microservice.loja.dto.ProdutoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @GetMapping("/info/{estado}")
    InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);

    @PostMapping("/pedido")
    InfoPedidoDto realizaPedido(List<ItemDaCompraDto> itens);

    @GetMapping("/valor/{valor}")
    ProdutoDto consultaValor(@PathVariable BigDecimal valor);

}
