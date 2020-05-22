class Product {
    int num;
    String name;
    int price;
    Product(int num, String name, int price) {
        this.num = num;
        this.name = name;
        this.price = price;
    }
}

// ...

// declare your array of `Product` objects...
Product[] products = new Product[size];

// ...

// then you can do something like
System.out.println("Enter product number:");
int prodNum = Integer.parseInt(a.readLine());
System.out.println("Enter product name:");
String prodName = a.readLine();
System.out.println("Enter product price:");
int prodPrice = Integer.parseInt(a.readLine());

products[INDEX] = new Product(prodNum, prodName, prodPrice);

// ...