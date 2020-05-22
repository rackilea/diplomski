public static void mergeXML(){


    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = null;
    Document doc = null;
    Document doc2 = null;

    try {
            db = dbf.newDocumentBuilder();
            doc = db.parse(new File("D:\\Loic_Workspace\\Test2\\res\\test.xml"));
            doc2 = db.parse(new File("D:\\Loic_Workspace\\Test2\\res\\test2.xml"));
            NodeList ndListFirstFile = doc.getElementsByTagName("staff");

            Node nodeArea = doc.importNode(doc2.getElementsByTagName("area").item(0), true);
            Node nodeCity = doc.importNode(doc2.getElementsByTagName("city").item(0), true);
            ndListFirstFile.item(0).appendChild(nodeArea);
            ndListFirstFile.item(0).appendChild(nodeCity);

          TransformerFactory tFactory = TransformerFactory.newInstance();
          Transformer transformer = tFactory.newTransformer();
          transformer.setOutputProperty(OutputKeys.INDENT, "yes");  

          DOMSource source = new DOMSource(doc);
          StreamResult result = new StreamResult(new StringWriter());
          transformer.transform(source, result); 

          Writer output = new BufferedWriter(new FileWriter("D:\\Loic_Workspace\\Test2\\res\\testFinal.xml"));
          String xmlOutput = result.getWriter().toString();  
          output.write(xmlOutput);
          output.close();

    } catch (ParserConfigurationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SAXException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (TransformerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


}