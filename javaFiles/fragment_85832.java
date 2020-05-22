@MessagingGateway(defaultHeaders = @GatewayHeader(name = "method", expression = "#gatewayMethod.name"))
interface Gate {

    @Gateway(requestChannel = "foo")
    void method1(String foo);

    @Gateway(requestChannel = "bar")
    void method2(String foo);

}