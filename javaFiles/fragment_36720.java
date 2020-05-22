import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rodrigoap
 * 
 */
public class UserInfoFilter implements Filter {

    /**
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // TODO
    }

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest))
            throw new ServletException("Can only process HttpServletRequest");
        if (!(response instanceof HttpServletResponse))
            throw new ServletException("Can only process HttpServletResponse");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpRequest.getSession().setAttribute("role", "user");
        httpRequest.getSession().setAttribute("id", "123");
                filterChain.doFilter(request, response);
    }

    /**
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO
    }

}