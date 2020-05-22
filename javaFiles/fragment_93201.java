@WebFilter("/*")
public class TrackingFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, 
              FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);

        String loggedInUser = "Unregistered user";

        //assuming you have a session attribute named user with the username
        if(session != null && session.getAttribute("user") != null) {
            loggedInUser = (String) session.getAttribute("user");
        }

        Date accessedDate = new Date();
        filterConfig.getServletContext().log(
                String.format("%s accessed context %s on %tF %tT",
                        loggedInUser, request.getRequestURI() , 
                              accessedDate, accessedDate)
        );

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}