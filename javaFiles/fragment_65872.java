package com.primavera.ws.jaxws.provider;

import javax.annotation.Resource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;

@WebServiceProvider(portName="MyPort", serviceName="MyService", targetNamespace="http://mytargetlocation", wsdlLocation="WEB-INF/wsdl/My.wsdl")
@ServiceMode(value = Service.Mode.MESSAGE)
@BindingType(HTTPBinding.HTTP_BINDING)

public class MyProvider implements Provider<Source> {

    @Resource
    private WebServiceContext context;


    public MyProvider()
    {
    }

    @Override
    public Source invoke(Source request)
    {
        MessageContext mc = context.getMessageContext();
        HttpSession session =    ((javax.servlet.http.HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
        if (session == null)
            throw new WebServiceException("No HTTP Session found");

        System.out.println("SessionID: " + session.getId());

        return request;
    }
}