public static void main(String[] args) throws Exception {    
    Document doc = new SAXReader().read(new File("D:/bb.xml"));
    Element root = doc.getRootElement();
    Iterator bbbIt = root.elementIterator();
    while (bbbIt.hasNext()) {
        Element bbb = ((Element) bbbIt.next());
        System.out.println("name:" + bbb.attributeValue("name"));
        Iterator cccIt = bbb.elementIterator();
        while (cccIt.hasNext()) {
            System.out.println("b:"
                    + ((Element) cccIt.next()).attributeValue("B"));
        }
    }

}