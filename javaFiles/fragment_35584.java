private ArrayList<ProductsClass> products

Products(){ 


    products = new ArrayList<ProductsClass>(); //Declaration and instantiation of ArrayList

    products.add(new ProductsClass("Bread", 0.65));
    products.add(new ProductsClass("Milk", 2.00));
    products.add(new ProductsClass("Pasta", 3.35));
    products.add(new ProductsClass("Milk chocolate bar", 0.75));
    products.add(new ProductsClass("Dark Rum", 25.00));

    ProductsClass p = products.get(3);
    System.out.print(p.getItemName() + ""); //Testing to see if works#
    System.out.print("");
    System.out.print(" " + p.getItemPrice());

}