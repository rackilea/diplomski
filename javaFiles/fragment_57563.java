@WebServlet(urlPatterns = "/mappings")
public class TestServlet extends HttpServlet {

    private static final long serialVersionUID = -7256602549310759826L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        Map<String, ? extends ServletRegistration> registrations = req
                .getServletContext().getServletRegistrations();

        for (String key : registrations.keySet()) {
            ServletRegistration registration = registrations.get(key);
            writer.write("Name: " + registration.getName());
            writer.write("<br>Mappings:");
            for (String mapping : registration.getMappings()) {
                writer.write(mapping);
            }
        }

        // of course you can write that to log or console also depending on your
        // requirement.
    }

}