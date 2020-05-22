Boolean remove(String path) throws ParserConfigurationException, SAXException, IOException
    {
    File fXmlFile = new File(path);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document XMLbook = dBuilder.parse(fXmlFile);
    Node root = XMLbook.getFirstChild(); //(1)
    Node book = XMLbook.getElementsByTagName("BOOK").item(0);//(2)
    NodeList chapterNodes = ((Element)book).getElementsByTagName("Chapter");
    Node subChapterNode=null;

    if(chapterNodes != null && chapterNodes.getLength() > 0) 
    {
        Node chapterNode = chapterNodes.item(chapterNodes.getLength() - 1);
        NodeList subChapterNodes = ((Element)chapterNode).getElementsByTagName("Subchapter");
        if(subChapterNodes != null && subChapterNodes.getLength() > 0) 
        {
            subChapterNode = subChapterNodes.item(subChapterNodes.getLength() - 1);
//          System.out.println(subChapterNode.getNodeName());
            Node toRemoveString=subChapterNode.getLastChild();
            subChapterNodes.removeChild(toRemoveString);    
            return Boolean.TRUE;
        }
    }
    return Boolean.FALSE;
    };