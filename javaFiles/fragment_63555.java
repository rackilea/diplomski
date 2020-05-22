public Map<String, Integer> countElements(File xmlFile) {

    Map<String, Integer> counts = new HashMap<>();

    try {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        FileInputStream fileInputStream = new FileInputStream(xmlFile);
        XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

        while(reader.hasNext()) {
            reader.next();
            if(reader.isStartElement() && reader.getLocalName().equals("SynsetRelation")) {
                String relTypeValue = reader.getAttributeValue("", "relType");

                if(!counts.containsKey(relTypeValue)) {
                    counts.put(relTypeValue, 0);
                }

                counts.put(relTypeValue, counts.get(relTypeValue) + 1);
            }
        }

        fileInputStream.close();
    } catch (XMLStreamException | IOException e) {
        e.printStackTrace();
    }

    return counts;
}