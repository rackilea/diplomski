public Document createSNMPMessage (){

    Element root = new Element("message");
    Document document = new Document(root);

    Element header = new Element("header");

    ...
    ...

    Element body = new Element("body");

    ...
    ...

    root.addContent(header);  // NOTE THESE NEW LINES
    root.addContent(body);  // NOTE THESE NEW LINES

    return document;

}