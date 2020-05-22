private TestSOAPPort getPort() {
    TestSOAPService service = new TestSOAPServiceImpl();
    try {
        registerResponseHandler(service);
        TestSOAPPort port = service.getTestSOAPPort();
        ((TestSOAPPortStub) port)._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY, TestConstants.ENDPOINT_URL);
        return port;
    } catch (Exception e) {
        // ...
    }

    return null;
}

private void registerResponseHandler(TestSOAPService service) {
    HandlerRegistry hr = service.getHandlerRegistry();
    QName portName = new QName(TestConstants.NAMESPACE_URI, TestConstants.PORT_NAME);
    List handlerChain = hr.getHandlerChain(portName);
    HandlerInfo hi = new HandlerInfo();
    hi.setHandlerClass(TestResponseHandler.class);
    handlerChain.add(hi);
}