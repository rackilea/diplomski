XMLFactoriesConfig xmlFactoriesConfig = new DefaultXMLFactoriesConfig(){
        @Override
        public DocumentBuilder createDocumentBuilder() {
            return new MyDocumentBuilder();
        }
    };

    XBProjector xbProjector = new XBProjector(xmlFactoriesConfig);