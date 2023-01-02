package produto.api.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import produto.api.spring.model.Produto;
import produto.api.spring.repository.ProdutoRepository;

@RestController
@RequestMapping("produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public Iterable<Produto> buscarTodos() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> buscarPorId(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
		if (produto.getId() == null)
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		else
			return null;
	}
	
	@PutMapping("/{id}")
	public Produto alterar(@PathVariable Long id, @RequestBody Produto produtoRequest) {
		Optional<Produto> produto = repository.findById(id);
		
		if (id == produtoRequest.getId())
		{
			produto.get().setCodigo(produtoRequest.getCodigo());
			produto.get().setDescricao(produtoRequest.getDescricao());
			return repository.save(produto.get());
		}
		else
			return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}	
}
