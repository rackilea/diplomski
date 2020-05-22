package org.arabellan.sandbox;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.glassfish.jersey.servlet.ServletContainer;

class Application {

    void run() throws Exception {
        ServletContextHandler httpContext = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        ServletContainer container = new ServletContainer(buildResourceConfig());
        ServletHolder holder = new ServletHolder(container);
        httpContext.setContextPath("/");
        httpContext.addServlet(holder, "/*");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(httpContext);
        jettyServer.start();
    }

    private ResourceConfig buildResourceConfig() {
        ResourceConfig config = new ResourceConfig();
        config.register(new GuiceToHK2(Main.injector));
        config.register(JacksonJsonProvider.class);
        config.registerClasses(EncodingFilter.class, GZipEncoder.class, DeflateEncoder.class);
        config.packages("org.arabellan.sandbox");
        return config;
    }

}