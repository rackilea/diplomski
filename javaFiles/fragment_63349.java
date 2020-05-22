import javax.xml.ws.BindingProvider;

((BindingProvider)soapService).getRequestContext()
    .put("com.sun.xml.ws.request.timeout", 5000L);
((BindingProvider)soapService).getRequestContext()
    .put("com.sun.xml.ws.connect.timeout", 5000L);