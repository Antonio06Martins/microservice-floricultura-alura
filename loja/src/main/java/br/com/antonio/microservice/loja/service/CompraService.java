package br.com.antonio.microservice.loja.service;

import br.com.antonio.microservice.loja.client.FornecedorClient;
import br.com.antonio.microservice.loja.dto.CompraDto;
import br.com.antonio.microservice.loja.dto.InfoFornecedorDto;
import br.com.antonio.microservice.loja.dto.InfoPedidoDto;
import br.com.antonio.microservice.loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class CompraService {

    private final Logger logger = LoggerFactory.getLogger(CompraService.class);

//    @Autowired
//    private RestTemplate client;

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDto compraDto) {

        final String estado = compraDto.getEndereco().getEstado();
        logger.info("Buscando informações do fornecedor de {}", estado);

        InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(compraDto.getEndereco().getEstado());

        logger.info("Realizando um pedido");
        InfoPedidoDto pedido = fornecedorClient.realizaPedido(compraDto.getItens());

        logger.info("O endereço é: {}", Objects.requireNonNull(info.getEndereco()));

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compraDto.getEndereco().toString());

        return compraSalva;

//        ResponseEntity<InfoFornecedorDto> exchange =
//                client.exchange("http://fornecedor/info/"+compraDto.getEndereco().getEstado(),
//                HttpMethod.GET, null, InfoFornecedorDto.class);
//
//        logger.info("O endereço é: {}", Objects.requireNonNull(exchange.getBody()).getEndereco());
    }
}
