public void save(java.io.File docxFile) throws Docx4JException {

    if (docxFile.getName().endsWith(".xml")) {

        // Create a org.docx4j.wml.Package object
        FlatOpcXmlCreator worker = new FlatOpcXmlCreator(this);
        org.docx4j.xmlPackage.Package pkg = worker.get();

        // Now marshall it
        JAXBContext jc = Context.jcXmlPackage;
        try {
            Marshaller marshaller=jc.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                                                   Boolean.TRUE);
            NamespacePrefixMapperUtils.setProperty(marshaller, 
                    NamespacePrefixMapperUtils.getPrefixMapper());          

            marshaller.marshal(pkg, new FileOutputStream(docxFile));
        } catch (Exception e) {
            throw new Docx4JException("Error saving Flat OPC XML", e);
        }   
        return;
    }

    SaveToZipFile saver = new SaveToZipFile(this); 
    saver.save(docxFile);
}