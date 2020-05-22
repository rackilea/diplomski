try{
    builder = new SAXBuilder(false);
    Document doc = builder.build(new InputSource(new StringReader(strXMLResponse)));

    Element root = doc.getRootElement();  
    Element rootchild = root.getChild(strService); 
    List rootchildren = rootchild.getChildren();

    for (int i=0;i <= rootchildren.size() -1;i++)  
    {  
        Element el = (Element) rootchildren.get(i);  

        if(el.getName().equalsIgnoreCase(strNode)){
            // do the transformation
            Source s = new JDOMSource(el);
            StringWriter resultWriter = new StringWriter();
            Result r = new StreamResult(resultWriter);
            templates.newTransformer().transform(s, r);
            return resultWriter.toString();
        }