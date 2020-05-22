public static void main(String[] args) {
  XMLOutputFactory factory      = XMLOutputFactory.newInstance();
  XMLEventFactory  eventFactory = XMLEventFactory.newInstance();
  try {

    StringWriter sw = new StringWriter();

    XMLEventWriter writer =
        factory.createXMLEventWriter(sw);

    XMLEvent event = eventFactory.createStartDocument("utf-8");
    writer.add(event);

    event = eventFactory.createStartElement(
        "", "", "test");
    writer.add(event);
    event = eventFactory.createEndElement(
        "", "", "test");
    writer.add(event);
    writer.flush();
    writer.close();

    sw.close();
    System.out.println(sw.toString());

  } catch (XMLStreamException e) {
    e.printStackTrace();
  } catch (IOException e) {
    e.printStackTrace();
  }
}