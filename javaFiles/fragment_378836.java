package com.home;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/webapi")
public class MyApplication extends ResourceConfig {

    public MyApplication() {

        register(ObjectMapperProvider.class);
        register(JacksonFeature.class);
        register(MyResource.class);

    }
}