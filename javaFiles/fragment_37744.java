public static void main (String [] args) {
    try {
        File xmlFile = new File("your_xml_file.xml");
        JAXBContext jaxbCtx = JAXBContext.newInstance(DataDocument.class);
        Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
        DataDocument dataDocument = (DataDocument) unmarshaller.unmarshal(xmlFile);
        System.out.println("data document is : " + dataDocument);
    } catch (JAXBException e) {
       e.printStackTrace ();
    }
}