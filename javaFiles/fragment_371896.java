public class SomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String someAttribute = servletContext.getAttribute("someAttribute");
        System.out.println("someAttribute value: " + someAttribute);
    }
}