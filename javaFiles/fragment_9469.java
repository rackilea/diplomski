DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

// root elements
Document doc = docBuilder.newDocument();
Element rootElement = doc.createElement("company");
doc.appendChild(rootElement);

// staff elements
Element staff = doc.createElement("Staff");
rootElement.appendChild(staff);

// set attribute to staff element
staff.setAttribute("id", "1");

// firstname elements
Element firstname = doc.createElement("firstname");
firstname.appendChild(doc.createTextNode("yong"));
staff.appendChild(firstname);

:
:

// Then write the doc into a StringWriter

Transformer transformer = TransformerFactory.newInstance().newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");

//initialize StreamResult with StringWriter object to save to string
StreamResult result = new StreamResult(new StringWriter());
DOMSource source = new DOMSource(doc);
transformer.transform(source, result);

String xmlString = result.getWriter().toString();
System.out.println(xmlString);

// Finally, send the response

byte[] res = xmlString.getBytes(Charset.forName("UTF-8"));
response.setCharacterEncoding("UTF-8");
response.getOutputStream().write(res);
response.flushBuffer();