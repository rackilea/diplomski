public void setCart(ArrayList<HashMap<String, String>> data) {
    if(cart != null && cart.size() > 0)
        cart.addAll(data);
    else
        cart = data;
}