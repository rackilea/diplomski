String xml = "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><CreateResponse xmlns=\"http://gtestserver/\"><CustomerId>8124138</CustomerId><InternalResponseCode>Success</InternalResponseCode><ResponseCode>0</ResponseCode><ResponseDate>2016-08-31T07:57:22.7760577Z</ResponseDate><ResponseDescription>Success</ResponseDescription><UserId>7424876375</UserId></CreateResponse></s:Body></s:Envelope>";

Document document = new SAXReader().read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
Node foundnode = null;
Element rootElement = document.getRootElement();
String namespace = rootElement.getNamespaceURI();

foundnode = document.selectSingleNode("//*[local-name()='CustomerId']");

System.out.println(foundnode.getText());