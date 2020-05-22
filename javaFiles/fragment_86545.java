System.out.println(description(element, ""));

public  String description(Node n, String tab){
        String str = new String();
        if(n instanceof Element){
            Element element = (Element)n;
            str += "<" + n.getNodeName();
            if(n.getAttributes() != null && n.getAttributes().getLength() > 0){
                NamedNodeMap att = n.getAttributes();
                int nbAtt = att.getLength();
                for(int j = 0; j < nbAtt; j++){
                    Node noeud = att.item(j);
                    str += " " + noeud.getNodeName() + "=\"" + noeud.getNodeValue() + "\" ";
                }
            }
            str += ">";
            if(n.getTextContent()!= null ){
                str += "<![CDATA[" + n.getTextContent().replace("\n", "").trim()+ "]]";
            }
            if(n.getChildNodes().getLength() == 1)
                str += n.getTextContent();
            int nbChild = n.getChildNodes().getLength();
            NodeList list = n.getChildNodes();
            String tab2 = tab + "\t";
            for(int i = 0; i < nbChild; i++){
                Node n2 = list.item(i);
                if (n2 instanceof Element){

                    str += "\n " + tab2 + description(n2, tab2);
                }
            }
            if(n.getChildNodes().getLength() < 2)
                str += "</" + n.getNodeName() + ">";
            else
                str += "\n" + tab +"</" + n.getNodeName() + ">";
        }
        return str;
    }