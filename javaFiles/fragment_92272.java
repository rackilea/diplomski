private void process(String row) throws SAXException {

    if (row.startsWith("  ")) {
        th.startElement("", "", "FILE_NAME", atts);
        th.characters(row.toCharArray(), 0, row.length());
        th.endElement("", "", "FILE_NAME"); 
    } else {
        th.startElement("", "", "CATALOG_NAME", atts);
        th.characters(row.toCharArray(), 0, row.length());
        th.startElement("", "", "CATALOG_NAME", atts);
    }

}