public void gettextperpage(PDDocument document, PDPageContentStream contentStream, ArrayList<Component> In, int startind) {
    int ht=740;
    int h=0;
    try {
            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(60,ht);

            int nbel=0;

            if (startind/13==8) {
                nbel=8;
                h=-280;
            }
            else {
                nbel=13;
                h=-10;
            }
            //System.out.println(nbel);
            for(int i=0; i<nbel;i++)
            {   
                int ind=startind+i;
                Component cp=In.get(ind);
                //contentStream.beginText(); 
                contentStream.showText(cp.toString());

                contentStream.newLineAtOffset(0,-LINE_HEIGHT-30);

                //contentStream.endText(); 
            }
            //contentStream.showText( "Company:"+_asc +"  "+_desc);
            contentStream.newLineAtOffset(250,h);
            contentStream.showText(Integer.toString((startind+13)/13));
            contentStream.endText();

            for (int i=0; i<nbel; i++)
            {
                int ind=startind+i;
                Component cp=In.get(ind);
                if (!cp.getimage().isEmpty()) {
                    String imagepath="photospieces/"+cp.getimage();
                    PDImageXObject pdImage = PDImageXObject.createFromFile(imagepath, document);
                    contentStream.drawImage(pdImage, 550, ht-40,40,40);

                }
                ht-=50;
            }
            contentStream.close();
        }
    catch (IOException ex) {
        ex.printStackTrace();
    }
    return contentStream;       
}

public void getoutputpdf(PDDocument document,ArrayList<Component> In) {
    headerpage(document);
    for (int k=0; k<9; k++) {
        try {
            //System.out.println(k);

            // Create a new blank page and add it to the document
            PDPage Page = new PDPage();
            document.addPage( Page );

            // Start a new content stream which will "hold" the to be created content
            PDPageContentStream contentStream = new PDPageContentStream(document, Page);
            contentStream=gettextperpage(document,contentStream,In,13*k);
            // Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}