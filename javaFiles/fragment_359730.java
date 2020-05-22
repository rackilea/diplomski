Boolean aa;
List<CartItem> cartItems = cartItemServices.findAllCartItems(cart);
for(CartItem cartItem1 : cartItems){
    if(cartItem1.getProduct().getName().equals(product.getName())){
        cartItemServices.update(user, cartItem1, product.getName());
        check=true;
        break;
    }
}
if(check==false){
    cartItemServices.save(user, cartItem, product.getName());
}