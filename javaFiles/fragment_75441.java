XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
            List<TercCode> tercCodeList = new ArrayList<TercCode>();

            try {
                XMLStreamReader xmlReader = xmlFactory.createXMLStreamReader(fname, stream);

                while (xmlReader.hasNext()) {
                    // returns the event type
                    int eventType = xmlReader.next();

                    // returns event type for reference
                    if (xmlReader.getEventType() == XMLStreamConstants.START_ELEMENT){
System.out.println(xmlReader.getName().getLocalPart());
}
} catch (XMLStreamException e) {
        e.printStackTrace();
    }