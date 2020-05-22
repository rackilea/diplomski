StringReader xmlInput = new StringReader(xmlStringWhichYouHaveCreated);
InputStream xslInput = getServletContext().getResourceAsStream("file.xsl"); // Or wherever it is. As long as you've it as an InputStream, it's fine.

Source xmlSource = new StreamSource(xmlInput);
Source xslSource = new StreamSource(xslInput);
Result xmlResult = new StreamResult(response.getOutputStream()); // XML result will be written to HTTP response.

Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
transformer.transform(xmlSource, xmlResult);