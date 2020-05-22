// write the SoapMessage to a String called xml
    File file= new File(pathToFile);
    file.createNewFile();
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    soapMessage.writeTo(fileOutputStream);
    fileOutputStream.flush();
    fileOutputStream.close();
    SAXBuilder b = new SAXBuilder();
    Document doc = b.build(file);
    XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
    xmlOutputter.output(doc, System.out);