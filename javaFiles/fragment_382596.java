public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

}



interface ProductRepositoryCustom {
    public String anyFunction();
}

@Repository
class ProductRepositoryImpl implements ProductRepositoryCustom {
    @Override
    public String anyFunction(){
         return "Hello";
    }
}