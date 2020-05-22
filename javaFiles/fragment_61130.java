FileInputStream xmlStream = new FileInputStream(new File("myxml.xml"));
    XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(xmlStream);
    while(reader.hasNext()){
        reader.next();
        for(int i=0; i < reader.getAttributeCount(); i++) {
           System.out.println(reader.getAttributeName(i) + "=" + reader.getAttributeValue(i));
        }
    }