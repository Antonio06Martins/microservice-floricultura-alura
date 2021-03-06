package br.com.antonio.microservice.fornecedor.repository;

import br.com.antonio.microservice.fornecedor.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
