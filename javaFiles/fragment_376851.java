SOAPEnvelope envelope = soapPart.getEnvelope();
envelope.addNamespaceDeclaration("xsi","http://www.w3.org/2001/XMLSchema-instance");
SOAPBody soapBody = envelope.getBody();
SOAPElement soapBodyElem = soapBody.addChildElement( "GetUserInfo" );
SOAPElement soapBodyElem1 = soapBodyElem.addChildElement( "ArgComKey" );
soapBodyElem1.addTextNode( "ComKey" ).setAttribute("xsi:type","xsd:integer");
SOAPElement soapBodyElem2 = soapBodyElem.addChildElement( "Arg" );
soapBodyElem2.addTextNode( "123" );