public static ReadXMLFile getInstance() {
       if (instance == null) {
            instance = new ReadXMLFile();
            instance.ParserForObjectTypes();
        }
        return instance;
    }