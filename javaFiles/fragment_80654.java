package org.example.sampleservice;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService(endpointInterface = "org.example.sampleservice.SampleService")
@HandlerChain(file="handlers.xml")
public class SampleServiceImpl implements SampleService {

    @Resource
    private WebServiceContext ctx;

    @Override
    public String sayHello(String name) {
        String usernameFromHeader = (String) ctx.getMessageContext().get("USERNAME");
        return "Hello, "
                + name
                + " (invoked by "
                + (usernameFromHeader == null ? "[err or no 'Security' header found]"
                        : usernameFromHeader) + ")";
    }

}