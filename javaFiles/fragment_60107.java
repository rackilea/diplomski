public static void parse() throws XMLStreamException, IOException {
    try (FileOutputStream fos = new FileOutputStream("test.xml")){
        XMLOutputFactory xmlOutFact = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = xmlOutFact.createXMLStreamWriter(fos);
        writer.writeStartDocument();
        writer.writeStartElement("test");
        // write stuff
        writer.writeEndElement();
    }
}