Source source = new StreamSource(new StringReader(s));

TransformerFactory transformerFactory = TransformerFactory.newInstance();
transformerFactory.setAttribute("indent-number", 4);

Transformer transformer = transformerFactory.newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");

StreamResult result = new StreamResult(new StringWriter());
transformer.transform(source, result);

String xmlOutput = result.getWriter().toString();
System.out.println(xmlOutput);

String xmlOutput = result.getWriter().toString();
System.out.println(xmlOutput);