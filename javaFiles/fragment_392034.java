package com.internal;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(ExampleRequest.class);

        File xml = new File("src/com/internal/input.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        ExampleRequest er = (ExampleRequest) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(er, System.out);
    }

}