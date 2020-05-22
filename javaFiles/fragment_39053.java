//Any class with queries
public class ProductService {

    @GraphQLQuery(name = "products")
    public Page<ProductEntity> getProducts(@GraphQLContext Store store, @GraphQLArgument(name = "count", defaultValue = "10") int count, @GraphQLArgument(name = "offset") int offset) {
        //your logic here, maybe delegating to the existing getProducts method
    }
}