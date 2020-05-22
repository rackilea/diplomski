package com.sample;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.representation.StringRepresentation;
import org.restlet.routing.Router;

public class MyApplication extends Application {

    public MyApplication() {
        super();
    }

    public MyApplication(Context parentContext) {
        super(parentContext);
    }

    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attach("/hello", HelloResource.class);

  Restlet mainpage = new Restlet() {
            @Override
            public void handle(Request request, Response response) {
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append("<html>");
                stringBuilder.append("<head><title>Hello Application " +
                        "Servlet Page</title></head>");
                stringBuilder.append("<body bgcolor=white>");
                stringBuilder.append("<a href=\"app/hello\">hello</a> --> returns hello world message " +
                        "and date string");
                stringBuilder.append("</body>");
                stringBuilder.append("</html>");
                response.setEntity(new StringRepresentation(
                        stringBuilder.toString(),
                        MediaType.TEXT_HTML));
            }
        };
        router.attach("", mainpage);

        return router;
    }

}