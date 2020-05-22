public void doPost(HttpServletRequest req, HttpServletResponse resp) {
  HttpSession session = req.getSession();
  Cart cart = (Cart) session.getAttribute("cart");
  if (cart == null) {
    cart = new Cart();
    session.setAttribute("cart", cart)
  };
  String id = req.getParamter("id");
  Integer quantity = Integer.parseInt(req.getParamter("quantity"));
  cart.addItem(id, quantity);
  // write your response
}