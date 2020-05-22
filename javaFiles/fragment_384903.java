package com.test;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/*")
public class TestApplication extends ResourceConfig {

    public TestApplication(){
        packages("com.test");
        register(JacksonFeature.class);
    }

}