TransformerFactory transformfactory = TransformerFactory.newInstance();
Templates xsl = transformfactory.newTemplates(new StreamSource(new FileInputStream((String)m_XslFile)));
Transformer transformer = xsl.newTransformer();
Document newdoc = docbuilder.newDocument();
Result XmlResult = new DOMResult(newdoc);
// now transform
transformer.transform(
        new DOMSource(doc.getDocumentElement()),
        XmlResult);