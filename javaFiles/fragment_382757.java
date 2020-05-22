public void doGet(HttpServletRequest req, HttpServletResponse resp) {
  Cart cart = (Cart) req.getSession().getAttribute("cart");
  if (cart != null) {
    // print items
  } else {
    // print an error
  }
}