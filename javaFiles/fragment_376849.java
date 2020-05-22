SOAPBody soapBody = envelope.getBody();
SOAPElement soapBodyElem = soapBody.addChildElement( "GetUserInfo" );
SOAPElement soapBodyElem1 = soapBodyElem.addChildElement( "ArgComKey", "", "xsd:integer" );
soapBodyElem1.addTextNode( "ComKey" );
SOAPElement soapBodyElem2 = soapBodyElem.addChildElement( "Arg" );
soapBodyElem2.addTextNode( "123" );