package br.com.igor.FastAndFuriosFood.controller;

import br.com.igor.FastAndFuriosFood.model.Pedido;
import br.com.igor.FastAndFuriosFood.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    
    @GetMapping
    public List<Pedido> listarTodos() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }


    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido) {
        pedido.setStatus("ABERTO"); 
        return repository.save(pedido);
    }

  
    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        return repository.findById(id).map(pedido -> {
            pedido.setCliente(pedidoAtualizado.getCliente());
            return repository.save(pedido);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void cancelar(@PathVariable Long id) {
        repository.findById(id).ifPresent(pedido -> {
            pedido.setStatus("CANCELADO");
            repository.save(pedido);
        });
    }
    @GetMapping("/status/{status}")
    public List<Pedido> buscarPorStatus(@PathVariable String status) {
        return repository.findByStatus(status);
    }

    @PutMapping("/status/{id}")
    public Pedido alterarStatus(@PathVariable Long id, @RequestBody Pedido pedidoComNovoStatus) {
        return repository.findById(id).map(pedido -> {
            pedido.setStatus(pedidoComNovoStatus.getStatus());
            return repository.save(pedido);
        }).orElse(null);
    }
}