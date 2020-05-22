DefaultHandler handler = new DefaultHandler() {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("settings")) {

            System.out.println("Parse settings attributes...");

            for (int index = 0; index < attributes.getLength(); index++) {

                String aln = attributes.getLocalName(index);
                String value = attributes.getValue(index);

                System.out.println("    " + aln + " = " + value);


            }

        }

    }
};