public class Product
{
  public float price;
  public String name;
}

public class prices {

public static void main(String[] args) {
    Product[] products = new Product[3];
    for (int i = 0; i < 3; i++) {
        products[i].name = JOptionPane.showInputDialog("product?"); 
        products[i].price = JOptionPane.showInputDialog("price?"); 
    }
}