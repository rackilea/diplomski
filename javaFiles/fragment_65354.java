Services servicehandle = new Services(new URL("http://172.16.2.3:8080/axis2/services/x?wsdl"));
    ServicesPortType port = servicehandle
            .getServicesHttpSoap11Endpoint();



      java.util.Map<String, Object> requestContext =
                               ((javax.xml.ws.BindingProvider)
                port).getRequestContext();
    requestContext.put("set-jaxb-validation-event-handler",  "false");