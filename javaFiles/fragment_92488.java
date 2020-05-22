URL wsdlURL = new URL("...");
QName serviceName = new QName("...", "...");
Service service = Service.create(wsdlURL, serviceName);
HandlerResolver handlerResolver = new ClientHandlerResolver();
service.setHandlerResolver(handlerResolver);
MyService myService = service.getPort(MyService.class);
// invoke methods (operations) on myService