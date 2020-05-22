public static void parse() throws XMLStreamException, IOException {
    try (FileInputStream fis = new FileInputStream("test.xml")) {
        XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
        XMLStreamReader reader = xmlInFact.createXMLStreamReader(fis);
        while(reader.hasNext()) {
            reader.next(); // do something here
        }
    }
}