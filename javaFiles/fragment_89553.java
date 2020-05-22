@WebFilter(urlPatterns={"/menu.xhtml"})
public class WelcomeFileFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ((HttpServletResponse) response).sendRedirect("faces/menu.xhtml");
    }

    // ...
}