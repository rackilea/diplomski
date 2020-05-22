@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public void deleteProductById(Long id) {

        System.out.println("Deleting product with id: " + id);

        // USE deleteById(Long id) and directly pass the id
        // Defined in CrudRepository
        repo.deleteById(id);

        // DON'T use delete() and pass a product
        //repo.delete(product);

    }
}