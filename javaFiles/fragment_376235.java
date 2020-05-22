public void add(Product p) {
    if (cart.size() > 0) {
        for (Product product : cart) {
            if (product.getName().equals(p.getName()) && product.getPrice() == p.getPrice()) {
                product.setQuantity(product.getQuantity() + p.getQuantity());
                return;
            }
        }
        cart.add(new Product(p));
    } else {
        cart.add(new Product(p));
    }
}