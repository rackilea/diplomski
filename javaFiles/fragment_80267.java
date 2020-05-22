Document doc = new Document();

SAXBuilder saxBuilder = new SAXBuilder();
try {
       doc = saxBuilder.build(new File("....path\MyXMLfile.xml")); 
    }
    catch (JDOMException ex) {
       System.err.println(ex);
    }
    catch (IOException ex) {
       System.err.println(ex);
    }


    Element root = esb.getRootElement();
    System.out.println(root.getName());  // it prints "definitions"

    Namespace namespace = Namespace.getNamespace("task","http://....myDefinitionsNamespace....");

    boolean b = root.removeChildren("task", namespace);

    System.out.println(b);

    XMLOutputter xmlOutputter = new XMLOutputter();
    xmlOutputter.setFormat(Format.getPrettyFormat());
    System.out.println(xmlOutputter.outputString(doc)); //so we can see new XML FILE