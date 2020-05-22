Element e = (Element) nl.item(i);
     NamedNodeMap attributes = e.getAttributes();
            for (int a = 0; a < attributes.getLength(); a++) 
       {
            Node theAttribute = attributes.item(a);
          System.out.println(theAttribute.getNodeName() + "=" + theAttribute.getNodeValue());
        }