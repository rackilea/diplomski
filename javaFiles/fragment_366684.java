import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

    @WebListener
    public class ServletContextListenerFilter implements ServletContextListener {

        public ServletContextListenerFilter() {}

        @Override
        public void contextDestroyed(ServletContextEvent arg0) {}

        @Override
        public void contextInitialized(ServletContextEvent sce) {
            ServletContext sc = sce.getServletContext();

            if (sc.getServletContextName().equals("Third party rest serice context name")) {
                sc.addFilter("FilterName", filterClass);
            }

        }
    }