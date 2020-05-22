public class StAx {
    public static void main(String[] args) throws FileNotFoundException,
            XMLStreamException {

        String filename = "HelloWorld.xml";

        try (InputStream in = new FileInputStream(filename);
                OutputStream out = System.out;) {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLOutputFactory xof = XMLOutputFactory.newInstance();
            XMLEventFactory ef = XMLEventFactory.newInstance();

            XMLEventReader reader = factory.createXMLEventReader(filename, in);
            XMLEventWriter writer = xof.createXMLEventWriter(out);

            while (reader.hasNext()) {
                XMLEvent event = (XMLEvent) reader.next();
                if (event.isCharacters()) {
                    String data = event.asCharacters().getData();
                    if (data.contains("Hello")) {
                        String replace = data.replace("Hello", "Oh");
                        event = ef.createCharacters(replace);
                    }
                    writer.add(event);
                } else if (event.isStartElement()) {
                    StartElement s = event.asStartElement();
                    String tagName = s.getName().getLocalPart();
                    if (tagName.equals("Name")) {
                        String newName = "Author" + tagName;
                        event = ef.createStartElement(new QName(newName), null,
                                null);
                        writer.add(event);
                        writer.add(ef.createCharacters("\n          "));
                        event = ef.createComment("auto generated comment");
                        writer.add(event);
                    } else {
                        writer.add(event);
                    }
                } else {
                    writer.add(event);
                }
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}