import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.springframework.context.ApplicationContext

public class SpringUtils {

    static getSpringBean(String name) {
        getApplicationContext().getBean(name);
    }

    static ApplicationContext getApplicationContext() {
        return ServletContextHolder.getServletContext().getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT);
    }    
}