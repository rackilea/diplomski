for(Object obj : elemetns){
   if(obj instanceof Tbl){
      Tbl table = (Tbl) obj;
         List rows = getAllElementFromObject(table, Tr.class);
            for(Object trObj : rows){
         Tr tr = (Tr) trObj;
         List cols = getAllElementFromObject(tr, Tc.class);
         for(Object tcObj : cols){
            Tc tc = (Tc) tcObj;
            List texts = getAllElementFromObject(tc, Text.class);
            for(Object textObj : texts){
              Text text = (Text) textObj;
                     if(text.getValue().equalsIgnoreCase("${MY_PLACE_HOLDER}")){
                        File file = new File("C:\\image.jpeg");
                 P paragraphWithImage = addInlineImageToParagraph(createInlineImage(file));
                        tc.getContent().remove(0);

                        tc.getContent().add(paragraphWithImage);
              }
                  }
           System.out.println("here");
         }
           }
        System.out.println("here");
    }
}

wordMLPackage.save(new java.io.File("C:\\result.docx"));