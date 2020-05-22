// Create the service
Service service = Service.create(serviceQName);
// Add a Port to the service and specify the SOAP 1.2 binding
service.addPort(serviceQName, javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING, wsUrl);
// Access the port
return service.getPort(serviceQName, portTypeClass);