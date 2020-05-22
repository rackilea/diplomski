import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShoppingCartUtil {

    public static ShoppingCart getShoppingCart(HttpServletRequest request, String sessionName) {
        return getShoppingCart(request.getSession(), sessionName);
    }

    public static ShoppingCart getShoppingCart(HttpSession session, String sessionName) {
        return (ShoppingCart)session.getAttribute(sessionName);
    }

    public static void addShoppingCartToSession(HttpServletRequest request, String sessionName, ShoppingCart cart) {
        addShoppingCartToSession(request.getSession(), sessionName, cart);
    }

    public static void addShoppingCartToSession(HttpSession session, String sessionName, ShoppingCart cart) {
        session.removeAttribute(sessionName);
        session.setAttribute(sessionName, cart);
    }
}