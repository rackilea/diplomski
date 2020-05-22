SOAPEnvelope envelope = soapPart.getEnvelope();
envelope.addNamespaceDeclaration("sh", serverURI );

//added code here
envelope.addNamespaceDeclaration("user", "http://www.website.com/ems/soap/sh/userdata" );
envelope.addNamespaceDeclaration("ser", "http://www.website.com/ems/soap/sh/servicedata" );