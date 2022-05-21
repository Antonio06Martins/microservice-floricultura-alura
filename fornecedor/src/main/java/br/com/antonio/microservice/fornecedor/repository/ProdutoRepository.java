package br.com.antonio.microservice.fornecedor.repository;

import br.com.antonio.microservice.fornecedor.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByEstado(String estado);

    List<Produto> findByIdIn(List<Long> ids);

    Produto findByPreco(BigDecimal preco);
}
