import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import testing.poc.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}