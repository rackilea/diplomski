// Parse the XML document
doc = ParseDocument(fileName);

// Deal with default namespace
HashMap map = new HashMap();
map.put( "ns", "http://www.cartest.co.uk");
Dom4jXPath xpath = new Dom4jXPath( "//ns:Car");
xpath.setNamespaceContext(new SimpleNamespaceContext(map));

List<Node> nodes = xpath.selectNodes(doc);

for(Node node : nodes)
{
    Element element = (Element)node;
    Iterator<Element> iterator = element.elementIterator();

    while(iterator.hasNext())
    {
      Element currentElement = (Element)iterator.next();

      if(currentElement.getName().equals("NoOfDoors"))
      {
         List<Element> elementList = currentElement.getParent().elements();      

         Iterator<Element> iterator2 = element.elementIterator();

         while(iterator2.hasNext())
         {

            Element newCurrentElement = (Element)iterator2.next();

            if(newCurrentElement.getName().equals("MaxSpeed"))
            {
                 newCurrentElement.detach();
                 elementList.add(elementList.indexOf(currentElement), newCurrentElement);
            }

      }
    }
}