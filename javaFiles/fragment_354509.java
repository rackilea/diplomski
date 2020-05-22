@Component(immediate = true, metatype = false, label = "Hello JSON Servlet")
@Service(serviceFactory = false, value = javax.servlet.Servlet.class)
@Properties(value = {
        @org.apache.felix.scr.annotations.Property(name = "sling.servlet.methods", value = { "GET" }),
        @org.apache.felix.scr.annotations.Property(name = "sling.servlet.extensions", value = { "json" }),
        @org.apache.felix.scr.annotations.Property(name = "sling.servlet.paths", value = {"/bin/TestServlet"})

})
public class HelloJSONServlet extends SlingAllMethodsServlet {

    protected void doGet(SlingHttpServletRequest request,
            SlingHttpServletResponse response) throws ServletException,
            IOException {
        String username = request.getParameter("username");
        response.setContentType("application/json");
        response.getWriter().write("{ \"hello\" : \""+username+"\" }");
    }
}