Element productElement = doc.createElement("product");
productElement.setAttribute("name", "value");
//Other name value pairs...

//Append the products element to the right spot.
Element productsElement = (Element) doc.getElementByTagName("products").item(0);
productsElement.appendChild(productElement);

//Convert doc to xml string
DOMSource domSource = new DOMSource(doc);
StringWriter writer = new StringWriter();
StreamResult result = new StreamResult(writer);
TransformerFactory tf = TransformerFactory.newInstance();
Transformer transformer = tf.newTransformer();
transformer.transform(domSource, result);
String xmlAsString = writer.toString();