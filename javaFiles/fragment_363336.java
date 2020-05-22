// location of wsdl file provided in URL format
// ex. file://localhost/C:/wsdl.wsdl for local file
String wsdlLocation = "wsdlLocation";

try{
    // we're assuming that you've already generated WS client side
    GeneratedService service = new GeneratedService(
        new URL(wsdlLocation),
        new QName("namespaceURI", "localPart"));

    GeneratedPort port = service.getGeneratedPort();

    SEIStub stub = (SEIStub) Proxy.getInvocationHandler(port);

    Field methodHandlersField =
        stub.getClass().getDeclaredField("methodHandlers");
    //hack to make private field accessible
    methodHandlersField.setAccessible(true);

    Method operationMethod = null;
    Object args = null;

    switch (somethingToTellYouWhatMethodToInvoke){
        case someMethodValue:
            operationMethod = GeneratedPort.class.getMethod(
                "methodName", classes, of, your, attributes);
            args = new Object[]{attributes, of, your, method};
            break;
        default:
            throw new SomeException("some message");
            break;
    }

    MethodHandler handler = ((Map<Method, MethodHandler>) methodHandlersField.
        get(stub)).get(operationMethod);

    Method createMessageMethod = handler.getClass().getSuperclass().
        getDeclaredMethod("createRequestMessage", Object[].class);
    //another hack
    createMessageMethod.setAccessible(true);

    Message message = (Message) createMessageMethod.invoke(handler, args);

    Transformer transformer =
        TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty(
        "{http://xml.apache.org/xslt}indent-amount", "2");
    transformer.transform(
        message.readPayloadAsSource(), new StreamResult(System.out));
} catch (Exception e){
    //lots of things to catch
    e.printStackTrace();
}