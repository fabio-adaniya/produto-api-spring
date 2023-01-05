package produto.api.spring.service;

import produto.api.spring.model.Produto;

public interface ProdutoService {
	Iterable<Produto> buscarTodos();
	Produto buscarPorId(Long id);
	Produto salvar(Produto produto);
	Produto alterar(Long id, Produto produtoRequest);
	String deletar(Long id);
}
