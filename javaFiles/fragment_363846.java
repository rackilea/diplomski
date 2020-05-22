public class ProductService {
    ProductDAO productDAO = new ProductDAO();

    public List<Product> list() throws SQLException{
       return productDAO.list();
    }
}