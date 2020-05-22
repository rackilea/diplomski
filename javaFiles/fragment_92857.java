SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser parser = factory.newSAXParser();

    DefaultHandler handler = new DefaultHandler() {
        boolean indexes;

        public void characters(char ch[], int start, int length)
                throws SAXException {
            String value = new String(ch, start, length);
            boolean changeState = value.startsWith("---");//change this, as you need
            if (!changeState && indexes){
                System.out.println(new String(ch, start, length));
            }
            if(changeState) indexes = !indexes;
        }

    };
    parser.parse(PATH_TO_FILE, handler);