package br.com.igor.FastAndFuriosFood.controller;



import br.com.igor.FastAndFuriosFood.dto.ProdutoDTO;
import br.com.igor.FastAndFuriosFood.model.Produto;
import br.com.igor.FastAndFuriosFood.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

  
    @GetMapping
    public List<Produto> listarTodos() {
        return repository.findAll(); 
    }

  

    @PostMapping
    public Produto salvar(@RequestBody ProdutoDTO dto) {
      
        Produto produto = new Produto();
        
  
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(dto.getCategoria());
        produto.setDescricao(dto.getDescricao());
        

        return repository.save(produto);
    }

 
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        return repository.findById(id).map(produto -> {
          
            produto.setNome(dto.getNome());
            produto.setPreco(dto.getPreco());
            produto.setCategoria(dto.getCategoria());
            produto.setDescricao(dto.getDescricao());
            
            return repository.save(produto);
        }).orElse(null);
    }}