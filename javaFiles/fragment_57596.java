// print the result
StringWriter writer = new StringWriter();
Transformer transformer2 = transformerFactory.newTransformer();
transformer2.transform(new DOMSource(resultDoc), new StreamResult(writer));
String str = writer.toString();
System.out.println(str);