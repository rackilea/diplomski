XMLInputFactory factory = XMLInputFactory.newInstance();
    XMLStreamReader reader = null;
    try (FileReader fr = new FileReader("file.xml")) { //Will close the FileReader
        reader = factory.createXMLStreamReader(fr);
        reader.close();
    }
    catch (XMLStreamException ex) {
        if(reader!=null)try {
            reader.close();
        } catch (XMLStreamException ex1) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }