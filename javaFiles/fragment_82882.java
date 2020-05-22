XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(System.out);
xmlStreamWriter.writeStartDocument();
xmlStreamWriter.writeStartElement("YourRootElement");
xmlStreamWriter.writeNamespace("xsi", "http://www.w3.org/2000/10/XMLSchema-instance");
xmlStreamWriter.writeAttribute("http://www.w3.org/2000/10/XMLSchema-instance", "noNamespaceSchemaLocation",
        "path_to_your.xsd");
xmlStreamWriter.writeEndElement();
xmlStreamWriter.flush();