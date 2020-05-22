public static ReadXMLFile getInstance() {
       if (instance == null) {
            instance = new ReadXMLFile();
        }
        return instance;
    }