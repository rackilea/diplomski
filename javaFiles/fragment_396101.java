public class SecurityFilter implements Filter
{
    public SecurityFilter()
    { 
    }

    public void init(FilterConfig conf) throws ServletException
    {
    }
    public void destroy()
    {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) {
        String id;

        HttpSession session = request.getSession(false);
        id = (String)session.getAttribute("sessionRadnikID");

        if(id == null) {
            //out.println("No session id");
            response.sendRedirect("login.jsp");
        } else {
            chain.doFilter(servletRequest, servletResponse);
        }
    }
}