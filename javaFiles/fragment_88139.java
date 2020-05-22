// Read the entire file
String text = new String(Files.readAllBytes(Paths.get("D:/input.txt")), StandardCharsets.UTF_8);

// Split into an array of strings, representing products
String[] prodStr = text.split(";");

// Create a list of product objects, currently empty
List<Product> prodList = new ArrayList<>();

// Loop over each product string
for (String pr : prodStr) {

    // Split this string into separate fields
    String[] fields = pr.split(":");

    // Build a product object from the fields
    Product product = new Product();
    product.id = fields[0];
    product.name = fields[1];
    product.price = fields[2];

    // Add this product to the list
    prodList.add(product);

}

// Print all the products to see what we get
System.out.println(prodList);