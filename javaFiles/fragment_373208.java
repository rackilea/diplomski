NodeList result1 = (NodeList) xPath.evaluate("/k:kml", mDocument, XPathConstants.NODESET);
System.out.println(String.valueOf(result1.getLength()));
System.out.println("Namespace URI: " + result1.item(0).getNamespaceURI());
System.out.println("Prefix: " + result1.item(0).getPrefix());

NodeList result2 = (NodeList) xPath.evaluate("/k:kml/k:Placemark", mDocument, XPathConstants.NODESET);
System.out.println( String.valueOf(result2.getLength()));
NodeList result3 = (NodeList) xPath.evaluate("/k:kml/k:Placemark/gx:Track", mDocument, XPathConstants.NODESET);
System.out.println(String.valueOf(result3.getLength()));