package demo;

import java.util.EnumSet;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.*;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;

public class SecurityInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        Dynamic registration =
                context.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        EnumSet<DispatcherType> dispatcherTypes =
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.ERROR, DispatcherType.ASYNC);
        registration.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
    }
}