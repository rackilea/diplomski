String[] fonts={"Arial", "Courier", "Times New Roman"};
         String[] fontsR={"arial","courier","times"};
         String[] styles={""," Bold"," Italic"," Bold Italic"};
         String[] stylesR={"","bd","i","bi"};
         for (int i=0;i<fonts.length;i++){
             for (int j=0;j<styles.length;j++){
                 String nameFont=fonts[i]+styles[j];
                 String nameTTF=fontsR[i]+stylesR[j];
                 TTFReader read=new TTFReader();
                 Document document=read.constructFontXML(read.loadTTF(chemin+"Fonts/ttf/"+nameTTF+".ttf", nameFont,true,true), nameFont, fonts[i], "C:/Fonts/ttf/"+nameTTF+".ttf"  ,"C:/Fonts/ttf/"+nameTTF+".ttf", true, fonts[i]);
                 Transformer transformer = TransformerFactory.newInstance().newTransformer();
                 Result output = new StreamResult(new File(chemin+"Fonts/xml/"+nameTTF+".xml"));
                 Source input = new DOMSource(document);
                 transformer.transform(input, output);