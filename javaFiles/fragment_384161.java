public class Product {
    static List<Product> productList = new ArrayList<Product>();
    String type;
    String material;
    String color;
    int n1;
    int n2;

    static void init() {
        productList.add( new Product("Trouser",40, 499,"Cotton", "Black"));
        productList.add( new Product("Shirt",32, 999, "Cotton","White"));
        productList.add( new Product("T-Shirt",32, 599 ,"Cotton","Blue"));
        productList.add( new Product("Blazer",32, 1299 ,"Cotton","Brown"));
    }

    Product (String type, int n1, int n2, String material, String color) {
        this.type = type;
        this.n1 = n1;
        this.n2 = n2;
        this.material = material;
        this.color = color;
    }
    public static void main(String [] ar)
    {
        init();
        for(Product pd : productList) {
            System.out.println(pd);
        }
    }
    @Override
    public String toString() {
        return(type + " " + n1 + " " + n2 + " " + material + " " + color);
    }
}