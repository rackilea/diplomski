package com.scotth.jaxrsrealpath;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * @author scotth
 * jax-rs application deployed to /JaxRsRealPath/
 */
@Path("sample")
public class SampleResource {

    @Context ServletContext servletContext;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello(@QueryParam("path") String requestedPath) {
        String path = requestedPath == null ? "/" : requestedPath;
        String actualPath = servletContext.getRealPath(path);
        return String.format("Hello, world! \nRequested path: %s\nActual path: %s", path, actualPath);
    }
}