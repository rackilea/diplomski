// Declarring streams:
FileReader fr = new FileReader(inputFile);
XMLStreamReader streamReader = inputFactory.createXMLStreamReader(fr);
...

// Closing streams.
fr.close();
streamReader.close();

// Deleting inputFile
deleteMethod();