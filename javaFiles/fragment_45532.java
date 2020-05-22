File directory = new File(txtSource.getText());
    File[] fList = directory.listFiles();
    for (File file : fList) {
        if (file.getName().startsWith("Config")) {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                Element rootElement = document.getDocumentElement();
                NodeList nameTags = rootElement.getElementsByTagName("Name");
                Node nameTag = nameTags.item(0);
                System.out.println("tag name: " + nameTag.getNodeName());
                System.out.println("tag text: " + nameTag.getFirstChild().getNodeValue());