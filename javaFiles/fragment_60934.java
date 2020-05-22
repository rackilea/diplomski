Reader r = new StringReader("<foo><filedata encoding=\"base64\">largeChunkEncodedHere</filedata></foo>");
    Writer w = new StringWriter();

    XMLInputFactory2 xmlif = (XMLInputFactory2)XMLInputFactory2.newInstance();
    XMLStreamReader2 sr = (XMLStreamReader2)xmlif.createXMLStreamReader(r);

    boolean flag = false;
    while (sr.hasNext()) {
        sr.next();
        if (sr.getEventType() == XMLStreamConstants.START_ELEMENT) {
            if ("filedata".equals(sr.getLocalName())) {
                flag = true;
            }
        }
        else if (sr.getEventType() == XMLStreamConstants.CHARACTERS) {
            if (flag) {
                sr.getText(w, false);
                break;
            }
        }
    }
    System.out.println(w);