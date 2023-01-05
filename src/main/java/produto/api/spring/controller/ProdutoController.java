package produto.api.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import produto.api.spring.model.Produto;
import produto.api.spring.service.ProdutoService;

@RestController
@RequestMapping("produto")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public Iterable<Produto> buscarTodos() {
		return produtoService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public Produto buscarPorId(@PathVariable Long id) {
		return produtoService.buscarPorId(id);
	}
	
	@PostMapping
	public Produto salvar(@RequestBody @Valid Produto produto) {
		return produtoService.salvar(produto);
	}
	
	@PutMapping("/{id}")
	public Produto alterar(@PathVariable Long id, @RequestBody @Valid Produto produtoRequest) {
		return produtoService.alterar(id, produtoRequest);
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		return produtoService.deletar(id);
	}	
}
