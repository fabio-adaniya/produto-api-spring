package produto.api.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import produto.api.spring.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
