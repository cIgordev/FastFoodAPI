package br.com.igor.FastAndFuriosFood.repository;

import br.com.igor.FastAndFuriosFood.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    List<Produto> findByCategoria(String categoria);
}
