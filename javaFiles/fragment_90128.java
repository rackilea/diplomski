public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("Stock.txt"));
    input.useDelimiter("-|\n");

    Product[] products = new Product[0];
    while(input.hasNext()) {
        int id = input.nextInt();
        String department = input.next();
        String name = input.next();
        double price = Double.valueOf(input.next().substring(1));
        int stock = input.nextInt();

        Product newProduct = new Product(name, price, department, id, stock);
        products = addProduct(products, newProduct);
    }

    for (Product product : products) {
        System.out.println(product);
    }
}

private static Product[] addProduct(Product[] products, Product productToAdd) {
    Product[] newProducts = new Product[products.length + 1];
    System.arraycopy(products, 0, newProducts, 0, products.length);
    newProducts[newProducts.length - 1] = productToAdd;

    return newProducts;
}

public static class Product {
    protected String name;
    protected double price;
    protected String department;
    protected int id;
    protected int stock;

    private static NumberFormat formatter = new DecimalFormat("#0.00");

    public Product(String n, double p, String d, int i, int s) {
        name = n;
        price = p;
        department = d;
        id = i;
        stock = s;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\r\nDepartment: %s\r\nName: %s\r\nPrice: %s\r\nStock: %d\r\n", 
                id, department, name, formatter.format(price), stock);
    }
}