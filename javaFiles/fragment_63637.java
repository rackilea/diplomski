MyServicePort myPort = new MyServiceInterface(new URL("https://acme.com/services/MyService.svc?wsdl")).getMyPort();
// set endpoint to use https
String endpointURL = "https://acme.com/services/MyService.svc";
BindingProvider bp = (BindingProvider) myPort;
bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);
myPort.test();