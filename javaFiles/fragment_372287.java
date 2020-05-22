public static void main(String[] args) {
    ServiceDetecnoPAC serviceDetecnoPAC = new ServiceDetecnoPAC();
    IDetecnoPac port = serviceDetecnoPAC.getPort(IDetecnoPac.class);

    ((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://www.detecno.mx/WCFTimbrador/DetecnoPac.svc?wsdl");

    Client client = ClientProxy.getClient(port);
    org.apache.cxf.endpoint.Endpoint cxfEndpoint = client.getEndpoint();

    port.obtenerHoraServidor();
}