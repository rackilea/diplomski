package org.example.consumer;

import java.net.URL;

import javax.xml.ws.BindingProvider;

import org.example.sampleservice.SampleService;
import org.example.sampleservice.SampleServiceImplService;

public class SayHelloClientApp {

    public static void main(String[] args) throws Exception {
        URL wsdlLoc = new URL("http://localhost:8081/samplews/sample?WSDL");
        SampleServiceImplService svc = new SampleServiceImplService(wsdlLoc);
        SampleService port = svc.getSampleServiceImplPort();

        BindingProvider bp = (BindingProvider) port;
        String endpointURL = "http://localhost:8081/samplews/sample?a=1&b=2&c=3";
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);

        String result = port.sayHello("java");
        System.out.println(String.format("Result:\n%s", result));
    }

}