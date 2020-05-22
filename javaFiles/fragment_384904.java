package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
public class TestResource {

    @GET
    @Produces("application/json")
    public Test getTest(){
        Test bean = new Test();
        bean.setName("Jersey");
        bean.setVersion("2.0");
        bean.setServlet("3.0");
        return bean;
    }

}