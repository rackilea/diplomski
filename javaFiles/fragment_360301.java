NodeList nl = node.getChildNodes();

    for (int i = 0; i < nl.getLength(); i++) {
       Node n = nl.item(i);
       if (n instanceof Element)
       {
           Element b = doc.createElement(n.getNodeName());
           //System.out.print(b);
           a.appendChild(b);
           Generer (doc,n,b);

       }
    }