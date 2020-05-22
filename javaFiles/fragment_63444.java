@WebListener
public class ManifestReader implements ServletContextListener {
    ...
    @Override
    public void contextInitialized(ServletContextEvent evt) {
        ServletContext ctx = servletContextEvent.getServletContext();
        InputStream is = ctx.getResourceAsStream("/META-INF/MANIFEST.MF");
        ...
    }
}