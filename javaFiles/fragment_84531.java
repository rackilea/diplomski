class SaxClass {
   Handler h1;
   Handler h2;

   //...stuff

   method() {
      h1 = new Handler();
      h2 = new Handler();

      try {
         SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
         SAXParser parser1 = SAXParserFactory.newInstance().newSAXParser();

         parser.parse(new File("G:\\Documents\\posts.xml"), h1);
         parser1.parse(new File("G:\\Documents\\comments.xml"), h2);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }

   class Handler extends DefaultHandler {
      // Implementation
   }
}