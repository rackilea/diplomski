package org.example.sampleservice;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "org.example.sampleservice.SampleService")
public class SampleServiceImpl implements SampleService {

    @Resource
    private WebServiceContext ctx;

    @Override
    public String sayHello(String name) {
        HttpServletRequest request = (HttpServletRequest) ctx.getMessageContext().get(MessageContext.SERVLET_REQUEST);

        String result = String.format("Hello, %s (invoked with endpoint query parameters %s)", name,
                request.getQueryString() == null ? "[no endpoint URL query parameters found]"
                        : request.getQueryString());
        return result;
    }

}