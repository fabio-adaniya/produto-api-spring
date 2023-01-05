package produto.api.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import produto.api.spring.model.Produto;
import produto.api.spring.model.ProdutoRepository;
import produto.api.spring.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	
	@Override
	public Iterable<Produto> buscarTodos() {
		return repository.findAll();
	}
	
	@Override
	public Produto buscarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Não existe produto com Id = " + id));
	}
	
	@Override
	public Produto salvar(Produto produto) {
		if (produto.getId() != null)
			throw new RuntimeException("O body da requisição não pode conter o campo Id");
		
		return repository.save(produto);
	}
	
	@Override
	public Produto alterar(Long id, Produto produtoRequest) {
		Produto produto = repository.findById(id).orElseThrow(() -> new RuntimeException("Não existe produto com Id = " + id));
		
		if (produtoRequest.getId() != null)
			throw new RuntimeException("O body da requisição não pode conter o campo Id");
		
		produto.setCodigo(produtoRequest.getCodigo());
		produto.setDescricao(produtoRequest.getDescricao());
		return repository.save(produto);
	}
	
	@Override
	public String deletar(Long id) {
		repository.findById(id).orElseThrow(() -> new RuntimeException("Não existe produto com Id = " + id));
		repository.deleteById(id);
		return "Produto com Id = " + id + " foi deletado com sucesso!";
	}
}
