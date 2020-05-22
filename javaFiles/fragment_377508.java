// ...

Document doc = docBuilder.parse(new File(FILENAME));
NodeList list = doc.getElementsByTagName("book");

// XXX collection of nodes to delete XXX
List<Node> delete = new ArrayList<Node>();

for (int i = 0; i <list.getLength(); i++) {

    Node node = list.item(i);
    NodeList childList = node.getChildNodes();

    // Looking through all children nodes
    for (int x = 0; x < childList.getLength(); x++) {

        Node child = childList.item(x);

        // To search only "book" children
        if (child.getNodeType() == Node.ELEMENT_NODE &&  
            child.getNodeName().equalsIgnoreCase("name") && 
            child.getTextContent().toUpperCase().equalsIgnoreCase("abcd".toUpperCase())) {
          // XXX just add to "to be deleted" list XXX
          delete.add( node );
          break;
        }
    }

}

// XXX delete nodes XXX
for( int i=0; i<delete.size(); i++ ) {
  Node node = delete.get( i );
  node.getParentNode().removeChild( node );
}

// ...