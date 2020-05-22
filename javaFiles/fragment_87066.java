NodeList LOP = odoc.getElementsByTagName("Your_XML_Top_Element");

                Node FPN =LOP.item(0);
                try{
                if(FPN.getNodeType() == Node.ELEMENT_NODE)
                    {

                    Element token = (Element)FPN;

                    NodeList oNameList1 = token.getElementsByTagName("Your_XML_Sub_Node");
                    Element firstNameElement = (Element)oNameList1.item(0);
                    NodeList textNList1 = firstNameElement.getChildNodes();

}