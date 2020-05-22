@WebFilter("*.jsp")
public class RedirectFilter implements Filter {

public void destroy() {}
public void init(FilterConfig fConfig) throws ServletException {}

/**
 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
 */
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    Object sessionStarted = ((HttpServletRequest)request).getSession(true).getAttribute("sessionStarted");
    if(sessionStarted==null){
        request.getServletContext().getRequestDispatcher("welcome.jsp").forward(request, response);
    }else{
        chain.doFilter(request, response);
    }
}
}