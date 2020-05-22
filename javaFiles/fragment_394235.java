public class MyMain {
    public static void main(String... args) throws Exception {
        Guice.createInjector(new MyServletModule());
        Server server = new Server(8080);    
        ServletContextHandler handler = 
            new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        handler.addFilter(GuiceFilter.class, "/*", allOf(DispatcherType.class));
        handler.addServlet(DefaultServlet.class, "/");
        server.start();
    }
}

@Singleton
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("Hello!\nYour path is: " + request.getServletPath());        
    }
}

public class MyServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        serve("/guice").with(MyServlet.class);
    }
}