public void addToCartButtonClicked(){
    //Set the variables of the cart.
    //Set customer to the cart.
    shoppingCart.setShopper(newCustomer);
    //Set Cart ID
    shoppingCart.setCartId(cartID);

    //Get selected product from the table, add to order then add to cart.
    ObservableList<Product> allProducts = shoppingTable.getItems();
    Order order = new Order();
    order.setProduct(shoppingTable.getSelectionModel().getSelectedItem());
    shoppingCart.addOrder(order);
    System.out.println(order);  
}