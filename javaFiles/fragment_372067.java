@RequestMapping(..)
public String someControllerMethod(HttpSession session) {
    session.setAttribute(Constants.CART, new Cart());
    ...
    Cart cart = (Cart) session.getAttribute(Constants.CART);
}