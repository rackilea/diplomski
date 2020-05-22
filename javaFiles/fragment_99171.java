public class testing1 extends PDFTOEXCEL implements Servlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("converted sucessfully");
        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        processRequest((HttpServletRequest)req, (HttpServletResponse)res);

    }
}