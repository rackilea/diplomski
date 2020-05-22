public enum StAXBatchWriter {
    INSTANCE;
    private static final Logger LOGGER = LoggerFactory.getLogger(StAXBatchWriter.class);

    public void writeUrls(File original, Collection<Town> towns) {
        XMLEventReader eventReader = null;
        XMLEventWriter eventWriter = null;
        try {
            String originalPath = original.getPath();
            File from = new File(original.getParent() + "/old-" + original.getName());
            boolean isRenamed = original.renameTo(from);
            if (!isRenamed)
                throw new IllegalStateException("Failed to rename file: " + original.getPath() + " to " + from.getPath());
            File to = new File(originalPath);

            XMLInputFactory inFactory = XMLInputFactory.newInstance();
            eventReader = inFactory.createXMLEventReader(new FileInputStream(from));

            XMLOutputFactory outFactory = XMLOutputFactory.newInstance();
            eventWriter = outFactory.createXMLEventWriter(new FileWriter(to));

            XMLEventFactory eventFactory = XMLEventFactory.newInstance();

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                eventWriter.add(event);
                if (event.getEventType() == XMLEvent.START_ELEMENT && event.asStartElement().getName().toString().contains("country")) {
                    for (Town town : towns) {
                        writeTown(eventWriter, eventFactory, town);
                    }
                }
            }
            boolean isDeleted = from.delete();
            if (!isDeleted)
                throw new IllegalStateException("Failed to delete old file: " + from.getPath());
        } catch (IOException | XMLStreamException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (eventReader != null)
                    eventReader.close();
            } catch (XMLStreamException e) {
                LOGGER.error(e.getMessage(), e);
            }
            try {
                if (eventWriter != null)
                    eventWriter.close();
            } catch (XMLStreamException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    private void writeTown(XMLEventWriter eventWriter, XMLEventFactory eventFactory, Town town) throws XMLStreamException {
        eventWriter.add(eventFactory.createStartElement("", null, "town"));

        // write town id
        eventWriter.add(eventFactory.createStartElement("", null, "id"));
        eventWriter.add(eventFactory.createCharacters(town.getId()));
        eventWriter.add(eventFactory.createEndElement("", null, "id"));

        //write town name
        if (StringUtils.isNotEmpty(town.getName())) {
            eventWriter.add(eventFactory.createStartElement("", null, "name"));
            eventWriter.add(eventFactory.createCharacters(town.getName()));
            eventWriter.add(eventFactory.createEndElement("", null, "name"));
        }

        // write other fields

        eventWriter.add(eventFactory.createEndElement("", null, "town"));
    }
}