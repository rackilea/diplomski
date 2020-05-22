public class ScannerStartup {

private static Logger logger = LoggerFactory.getLogger(ScannerStartup.class);
private static final int DEFAULT_PORT = 8080;
private static final String CONTEXT_PATH = "/";
// Package of the config class
private static final String CONFIG_LOCATION = "com.tpv.req.config";
private static final String MAPPING_URL = "/*";

public static void main(String args[]) throws Exception {
    startJetty(getPortFromArgs(args));
}

private static int getPortFromArgs(String[] args) {
    if (args.length > 0) {
        try {
            return Integer.valueOf(args[0]);
        } catch (NumberFormatException ignore) {
        }
    }
    logger.debug("No server port configured, falling back to {}", DEFAULT_PORT);
    return DEFAULT_PORT;
}

private static void startJetty(int port) throws Exception {
    Server server = new Server(port);
    server.setHandler(getServletContextHandler(getContext()));
    server.start();
    logger.info("Server started at port {}", port);
    server.join();
}

private static ServletContextHandler getServletContextHandler(WebApplicationContext context) throws IOException {
    ServletContextHandler contextHandler = new ServletContextHandler();
    contextHandler.setErrorHandler(null);
    contextHandler.setContextPath(CONTEXT_PATH);
    contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), MAPPING_URL);
    contextHandler.addEventListener(new ContextLoaderListener(context));
    return contextHandler;
}

private static WebApplicationContext getContext() {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.setConfigLocation(CONFIG_LOCATION);
    return context;
}