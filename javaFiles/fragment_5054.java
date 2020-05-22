package com.sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shiva Saxena
 *
 */
@WebServlet(name = "CarServiceServlet", value = "/CarService.svc/*", initParams = {
    @WebInitParam(name = "javax.ws.rs.Application", value = "org.apache.olingo.odata2.core.rest.app.ODataApplication"),
    @WebInitParam(name = "org.apache.olingo.odata2.service.factory", value = "com.sample.CarServiceFactory") })
public class MyServlet extends CXFNonSpringJaxrsServlet {

    Logger logger = LoggerFactory.getLogger(MyServlet.class);

    private static final long serialVersionUID = -5663461069269732798L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        // It is not necessory to override this function.Its here just for logging and better understanding 
        logger.info("Call intercepted by:" + this.getClass().getName());
        super.service(req, res);
    }

}