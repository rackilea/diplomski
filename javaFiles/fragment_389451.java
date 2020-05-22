XMLInputFactory xmlif = XMLInputFactory.newInstance();
    xmlif.setProperty(XMLInputFactory.IS_COALESCING, true);
    XMLStreamReader xmlsr;
    String resultat="";
    boolean isGetme=false;

    try {
        xmlsr = xmlif.createXMLStreamReader(new FileReader("lib/toto.xml"));
        int eventType;
        while (xmlsr.hasNext()) {
            eventType = xmlsr.next();
            switch (eventType) {
                case XMLStreamConstants.START_ELEMENT:
                    if(xmlsr.getLocalName().equals("getMe")){
                        isGetme=true;
                    }
                    if(isGetme){
                        resultat+="<"+xmlsr.getLocalName()+">";
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if(isGetme){
                        resultat+=xmlsr.getText();
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if(xmlsr.getLocalName().equals("getMe")){
                        resultat+="</"+xmlsr.getLocalName()+">";
                        isGetme=false;
                    }
                    if(isGetme && !xmlsr.getLocalName().equals("getMe")){
                        resultat+="</"+xmlsr.getLocalName()+">";
                    }
                    break;
                default:
                    break;
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (XMLStreamException e) {
        e.printStackTrace();
    }
    System.out.println(resultat);