if(node.hasChildNodes()) 
{ 
    NodeList nl = node.getChildNodes(); 
    for(int i = 0; i < nl.getLength(); i++) 
    { 
        nodeList.add(nl.item(i)); 
    } 
}