package br.com.igor.FastAndFuriosFood.repository;

import br.com.igor.FastAndFuriosFood.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    

    List<Pedido> findByStatus(String status);
    
}