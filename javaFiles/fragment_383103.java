DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    try {
          //Using factory get an instance of document builder
           DocumentBuilder db = dbf.newDocumentBuilder();
           InputSource is = new InputSource();
           is.setCharacterStream(new StringReader(content)); //content variable holding xml records         
           Document doc = db.parse(is)
           /* Now retrieve data from xml */
           NodeList nodes = doc.getElementsByTagName("ResultSet");
           Element elm = (Element) nodes.item(0);   //will get you <Response> Successfully Sent.</Response>
           String responseText = elm.getFirstChild().getNodeValue();

    }catch(ParserConfigurationException pce) {
        pce.printStackTrace();
    }catch(SAXException se) {
        se.printStackTrace();
    }catch(IOException ioe) {
        ioe.printStackTrace();
    }