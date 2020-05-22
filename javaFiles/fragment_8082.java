public void characters(char[] ch, int start, int length)
        throws SAXException {

    if (fTitle) {
        titleResult = titleResult + (new String(ch, start, length))
                + "\t\n";
        fTitle = false;
    }

    if (fDesc) {
        titleResult = titleResult + (new String(ch, start, length))
                + "\t\n\n";
        fDesc = false;
    }
}