class SAXParser extends DefaultHandler 
{
    static int i = 0;
    ArrayList<ArrayList<String>> ar = new ArrayList<ArrayList<String>>();
    // ***** Instead of creating the list here *****
    // ArrayList<String> id = new ArrayList<String>();

    public void startElement(String uri, String localName, String qName, Attributes atts) {
        if (qName.equals("row")) {
            // ***** Move that line here: *****
            ArrayList<String> id = new ArrayList<String>();

            int idx = 0;
            id.add(idx, atts.getValue(0));
            idx++;
            id.add(idx, atts.getValue(3));
            ar.add(i, id);
            i++;
            //idx = 0;
        }
    }
}