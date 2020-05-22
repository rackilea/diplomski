import java.util.List;
import java.util.ArrayList;

public class Customer {
    public List<Product> products = new ArrayList<Product>();

    public void addProduct(Product p){
        products.add(p);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        Jamon jamon = new Jamon("Jabugo", 25.0);
        Pepino pepino = new Pepino("Extra picante", 8.50);
        Jamon negro = new Jamon("Pata Negra", 32.99);
        customer.addProduct(jamon);
        customer.addProduct(pepino);
        customer.addProduct(negro);
        for (Product product : customer.products) {
            System.out.println(product.getClass());
        }
    }
}