package org.test;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/rest/*"}, initParams = {
    @WebInitParam(name = "com.sun.jersey.config.property.packages",
            value = "org.test.rest")})
public class JerseyServlet extends SpringServlet {

}