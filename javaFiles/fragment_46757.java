private MyTagObject parseMyTag(XMLStreamReader reader, String myTag) throws XMLStreamException {
    MyTagObject myTagObject = new MyTagObject();
    while (true) {
        switch (reader.next()) {
        case XMLStreamConstants.START_ELEMENT:
            String localName = reader.getLocalName();
            if(localName.equals("myOtherTag1")) {
                myTagObject.setMyOtherTag1(parseMyOtherTag1(reader, localName));
            } else if(localName.equals("myOtherTag2")) {
                myTagObject.setMyOtherTag2(parseMyOtherTag2(reader, localName));
            }
            // and so on
            break;
        case XMLStreamConstants.END_ELEMENT:
            if(reader.getLocalName().equals(myTag) {
                return myTagObject;
            }
            break;
    }
}