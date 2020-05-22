public class AjaxEmptyResponseFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        if (!response.isCommitted()) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            Writer writer = response.getWriter();
            writer.write("null");
            writer.close();
            response.flushBuffer();
        }
    }

}