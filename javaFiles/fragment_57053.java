import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;

public class Main {
    public static void main(String[] args) {
        final Server server = new Server(8080);
        final WebAppContext webAppContext = new WebAppContext();
        webAppContext.setErrorHandler(null);
        webAppContext.setContextPath("/");

        final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.example.config");
        context.getEnvironment().setDefaultProfiles("dev");

        webAppContext.addServlet(new ServletHolder(new DispatcherServlet(context)), "/");
        webAppContext.addEventListener(new ContextLoaderListener(context));


        try {
            webAppContext.setResourceBase(new ClassPathResource("webapp").getURI().toString());
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        server.setHandler(webAppContext);
        try {
            server.start();
            server.join();
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}