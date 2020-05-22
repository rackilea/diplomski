//parse the xml file
Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("file.xml"));

//get all elements called fo:external-graphic
NodeList list = doc.getElementsByTagName("fo:external-graphic");
for(int i = 0 ; i < list.getLength() ; i++){
    Element element = (Element)list.item(i);
    NamedNodeMap attributes = element.getAttributes();

    //change the src attribute
    Attr src = (Attr)attributes.getNamedItem("src");
    System.out.println(src.getValue());
    src.setValue("url('another/path/box.jpg')");
}

//let's print out the resulting doc for debugging purposes
OutputFormat format = new OutputFormat(doc);
format.setLineWidth(65);
format.setIndenting(true);
format.setIndent(2);
Writer out = new StringWriter();
XMLSerializer serializer = new XMLSerializer(out, format);
serializer.serialize(doc);
System.out.println(out.toString());