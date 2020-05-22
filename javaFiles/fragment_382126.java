XMLEventWriter eventWriter;
    XMLEventFactory eventFactory;
    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream("testMerge1.xml"));
    eventFactory = XMLEventFactory.newInstance();
    XMLEvent newLine = eventFactory.createDTD("\n");                
    // Create and write Start Tag
    StartDocument startDocument = eventFactory.createStartDocument();
    eventWriter.add(startDocument);
    eventWriter.add(newLine);
    StartElement configStartElement = eventFactory.createStartElement("","","TestCaseBlock");
    eventWriter.add(configStartElement);
    eventWriter.add(newLine);
    String[] filenames = new String[]{"test1.xml", "test2.xml","test3.xml"};
    for(String filename:filenames){
           XMLEventReader test = inputFactory.createXMLEventReader(filename,
                             new FileInputStream(filename));
        while(test.hasNext()){
            XMLEvent event= test.nextEvent();
        //avoiding start(<?xml version="1.0"?>) and end of the documents;
        if (event.getEventType()!= XMLEvent.START_DOCUMENT && event.getEventType() != XMLEvent.END_DOCUMENT)
                eventWriter.add(event);         
        eventWriter.add(newLine);
            test.close();
        }           
    eventWriter.add(eventFactory.createEndElement("", "", "TestCaseBlock"));
    eventWriter.add(newLine);
    eventWriter.add(eventFactory.createEndDocument());
    eventWriter.close();