public void iterateNodes() {
     SAXReader reader = new SAXReader();
     Document document = reader.read("yourxml.xml");
     Element root = document.getRootElement();
     for ( Iterator i = root.elementIterator(); i.hasNext(); ){
           Element row = (Element) i.next();
           Iterator itr = row.elementIterator();
           while(itr.hasNext()) {
                Element child = (Element) itr.next();
                String name = child.getQualifiedName();
                if(name.equals("requiredName") {
                   //create node and add it to child.
                }   
           }
     }
 }