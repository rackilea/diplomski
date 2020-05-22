public static void toXSD() {
    SAXBuilder saxBuilder = new SAXBuilder();
    Document document;
        try {
            document = saxBuilder.build(new File("D:\\Users\\schintha\\Desktop\\Work\\\test_files\\SUMMARY_11.xml"));
            for (Element element : document.getRootElement().getChildren()) {
                System.out.println("Name = " + element.getName());
                System.out.println("Value = " + StringEscapeUtils.escapeXml10(element.getValue()));                                  
            }        
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();}}