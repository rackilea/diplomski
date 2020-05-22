class xmlHandler extends DefaultHandler {
    private Vector nodes = new Vector();
    private Stack tagStack = new Stack();

    public void startDocument() throws SAXException {
    }

    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        // System.out.println("1");
        if (qName.equals("clause")) {
            Noden node = new Noden();
            nodes.addElement(node);
            // System.out.println("2");
        }
        // System.out.println("3");
        tagStack.push(qName);
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String chars = new String(ch, start, length).trim();

        if (chars.length() > 0) {
            String qName = (String) tagStack.peek();
            Noden currentnode = (Noden) nodes.lastElement();
            // System.out.println(qName);

            if (qName.equals("en")) {
                currentnode.setEn(chars);
            } else if (qName.equals("alt")) {
                currentnode.setAlt(chars);
            }
        }
    }

    public void endElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        tagStack.pop();
    }

    public void endDocument() throws SAXException {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < nodes.size(); i++) {
            Noden currentnode = (Noden) nodes.elementAt(i);
            result.append("En : " + currentnode.getEn() + " Alt : "
                    + currentnode.getAlt() + "\n");
        }
        System.out.println(result.toString());
    }

    class Noden {
        private String en;
        private String alt;

        public Noden() {
        }

        public void setEn(String en) {
            this.en = en;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getEn() {
            return en;
        }

        public String getAlt() {
            return alt;
        }
    };