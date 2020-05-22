public static void main(String[] args) throws Exception {
     DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
        .newInstance();
     DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
     docBuilder.isValidating();

     Document xml = docBuilder.parse(new File("input.xml"));

     database db = new database();
     db.save(xml);
  }