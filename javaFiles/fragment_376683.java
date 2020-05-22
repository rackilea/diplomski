DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();        
    EntityResolver er = new EntityResolver() {            
        @Override
        public InputSource resolveEntity(String publicId, String systemId)
                throws SAXException, IOException {
            System.out.println(publicId);
            System.out.println(systemId);
             if (systemId.startsWith("<") && systemId.endsWith(">")) {
                    return new InputSource(systemId.substring(1,systemId.length()-1));
            }
            return null;
        }
    };        
    db.setEntityResolver(er);
    db.parse(inputStream , "UTF-8");