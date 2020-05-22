package com.java.json;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.jaxb.XmlJaxbAnnotationIntrospector;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.tda.trident.beb.AuthInfo;

public class XmlDoc {

public static void main(String[] args) throws Exception {
    String xmlstring = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.web.post.list.com\"><soapenv:Header><authInfo xsi:type=\"soap:authentication\" xmlns:soap=\"http://list.com/services/SoapRequestProcessor\"><!--You may enter the following 2 items in any order--><username xsi:type=\"xsd:string\">user@email.com</username><password xsi:type=\"xsd:string\">password</password></authInfo></soapenv:Header></soapenv:Envelope>";
    //String xmlstring = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.web.post.list.com\"><soapenv:Header><authInfo xsi:type=\"soap:authentication\" xmlns:soap=\"http://list.com/services/SoapRequestProcessor\"><!--You may enter the following 2 items in any order--><username xsi:type=\"xsd:string\">user@email.com</username><username xsi:type=\"xsd:string\">user@email.com</username><password xsi:type=\"xsd:string\">password</password></authInfo></soapenv:Header></soapenv:Envelope>";
    Object messageObj = null;       

    XmlMapper unmarshaller = new XmlMapper();
    unmarshaller.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    XmlJaxbAnnotationIntrospector xmlIntrospector = new XmlJaxbAnnotationIntrospector();
    unmarshaller.setAnnotationIntrospector(xmlIntrospector);
    JaxbAnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
    ObjectMapper marshaller = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    marshaller.setSerializationInclusion(Include.NON_NULL);
    marshaller.setAnnotationIntrospector(introspector);

    TransactionTradeMessage rootNode = unmarshaller.readValue(xmlstring, AuthInfo.class);

    messageObj = rootNode.getTransactionTrade();

    System.out.println(marshaller.writeValueAsString(messageObj));

}
}