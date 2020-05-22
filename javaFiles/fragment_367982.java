import com.sun.xml.ws.developer.SchemaValidationFeature;
...

SchemaValidationFeature feature = new SchemaValidationFeature();
HelloPort port = new HelloService.getHelloPort(feature);
// All invocations on this port are validated