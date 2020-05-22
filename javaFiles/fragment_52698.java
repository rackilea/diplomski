FileInputStream fis = new FileInputStream(file);

XMLInputFactory factory = XMLInputFactory.newInstance();
XMLStreamReader staxXmlReader = factory.createXMLStreamReader(fis);

XMLOutputFactory outFactory = XMLOutputFactory.newInstance();
XMLStreamWriter staxWriter = outFactory.createXMLStreamWriter(out);

for (int event = staxXmlReader.next(); event != XMLStreamConstants.END_DOCUMENT; 
     event = staxXmlReader.next()) {

    switch (event) {
    case XMLStreamConstants.START_DOCUMENT:
        break;
    case XMLStreamConstants.START_ELEMENT:
        String elementName = staxXmlReader.getLocalName();
        if(elementName.equals("address-list")){
            staxWriter.writeStartElement(elementName);
            String addressText = staxXmlReader.getElementText();
            // parse element text
            // and loop creating <address> elements
            for (..) {
                staxWriter.writeStartElement("address");  // write <address>
                staxWriter.writeCharacters("address data");
                staxWriter.writeEndElement();  // write </address>
            }
        } else {
            // just copy the element
            staxWriter.writeStartElement(elementName);
            staxWriter.writeCharacters(staxXmlReader.getElementText());
        }
        break;
    case XMLStreamConstants.END_ELEMENT:
        staxWriter.writeEndElement();
        break;
    case XMLStreamConstants.END_DOCUMENT:
        staxWriter.writeEndDocument();
        break;
    default:
         break;
    }
}