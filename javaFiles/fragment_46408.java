XMLEventFactory eventFactory = XMLEventFactory.newInstance();
XMLEvent dtd = eventFactory
    .createDTD("<!DOCTYPE Employee SYSTEM \"xmlValidate.dtd\">");

XMLInputFactory inFactory = XMLInputFactory.newInstance();
XMLOutputFactory outFactory = XMLOutputFactory.newInstance();
XMLEventReader reader = inFactory
    .createXMLEventReader(new StreamSource(
        "xmlValidate.xml"));
reader = new DTDReplacer(reader, dtd);
XMLEventWriter writer = outFactory.createXMLEventWriter(System.out);
writer.add(reader);
writer.flush();

// TODO error and proper stream handling