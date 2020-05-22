import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RestrictionFilter implements Filter {
    private static final String ACCES_PUBLIC     = "/loginPage.jsp";
    private static final String ATT_SESSION_USER = "user";

    public void init( FilterConfig config ) throws ServletException {
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
            ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final HttpSession session = request.getSession();

        /**
         * check if user is not connected.
         */
        if (session.getAttribute( ATT_SESSION_USER ) == null) {
            /* Redirection to login page */
            response.sendRedirect( request.getContextPath() + ACCES_PUBLIC );
        } else {
            /** access granted for the user*/
            chain.doFilter( request, response );
        }
    }

    public void destroy() {
    }
}