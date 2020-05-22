import org.apache.catalina.Context;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;

import javax.servlet.Filter;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.File;

/**
 * @author Paul Samsotha.
 */
public class Main {

    public static void main(String... args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9000);

        File base = new File(".");
        Context context = tomcat.addContext("", base.getAbsolutePath());

        Tomcat.addServlet(context, "default", new DefaultServlet());
        context.addServletMapping("/*", "default");

        final FilterDef def = new FilterDef();
        final FilterMap map = new FilterMap();

        def.setFilterName("jerseyFilter");
        def.setFilter(getJerseyFilter());
        context.addFilterDef(def);

        map.setFilterName("jerseyFilter");
        map.addURLPattern("/api/*");
        context.addFilterMap(map);

        tomcat.start();

        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Filter getJerseyFilter() {
        final ResourceConfig config = new ResourceConfig()
                .register(new HelloResource(new Service()))
                .register(JspMvcFeature.class)
                .property(ServletProperties.FILTER_FORWARD_ON_404, true);
        return new ServletContainer(config);
    }

    public static class Service {
        public String getMessage() {
            return "Hello Tomcat!";
        }
    }

    @Path("tomcat")
    public static class HelloResource {
        private final Service service;

        public HelloResource (Service service) {
            this.service = service;
        }

        @GET
        public String get() {
            return this.service.getMessage();
        }
    }
}