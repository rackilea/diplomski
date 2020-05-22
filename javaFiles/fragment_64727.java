SAXParserFactory.newInstance().newSAXParser()
            .parse(new File("1.xml"), new DefaultHandler() {
                String url;
                String element;

                @Override
                public void startElement(String uri, String localName, String qName,
                        Attributes attributes) throws SAXException {
                    element = qName;
                    url = "";
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (element.equals("link_site")) {
                        url += new String(ch, start, length); 
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName)
                        throws SAXException {
                    if (element.equals("link_site")) {
                        System.out.println(url.trim());
                        element = "";
                    }
                }
            });