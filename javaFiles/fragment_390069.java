package org.test.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.service.DummyService;

@Path("test")
@Component
public class TestResource {

    @Autowired
    private DummyService service;

    @GET
    public String test() {
        return service.sayHello();
    }

}