public void displayPage(User user) {
    display(user.getName());

    if (user.hasView(Customer.class))
       displayShoppingCart(user.getView(Customer.class);

    if (user.hasView(Seller.class))
       displayProducts(user.getView(Seller.class));
}