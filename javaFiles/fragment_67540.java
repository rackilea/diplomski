public void startElement(String uri, String localName, String qName, Attributes atts) {
    if (qName.equals("row")) {
        ArrayList<String> id = new ArrayList<String>();
        id.add(atts.getValue(0));
        id.add(atts.getValue(3));
        ar.add(id);
    }
}