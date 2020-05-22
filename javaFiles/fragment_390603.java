package com.sample;

import java.util.Calendar;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class HelloResource extends ServerResource {

    public HelloResource() {
        super();
    }
    public HelloResource(Context context,
                          Request request,
                          Response response) {     
        getVariants().add(new Variant(MediaType.TEXT_PLAIN));
    }

    @Override
    protected Representation get() throws ResourceException {
        String message = "Hello World!" +
        " \n\nTime of request is:"
        + Calendar.getInstance()
        .getTime().toString();

        return new StringRepresentation(message,
        MediaType.TEXT_PLAIN);
    }

}