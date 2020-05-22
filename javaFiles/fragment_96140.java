public processPDF(int xOne, int yOne, int xTwo, int yTwo)
{
    //create pdf and its contents for one page
    PDDocument document = new PDDocument();
    File file = new File("hello.pdf");
    PDPage page = new PDPage();
    PDFont font = PDType1Font.HELVETICA_BOLD;
    PDPageContentStream contentStream;

    try {
        //create content stream
        contentStream = new PDPageContentStream(document, page);

        //being to create our text for our page
        contentStream.beginText();
        contentStream.setFont( font, largeTitle);

        //position of text
        contentStream.moveTextPositionByAmount(xOne, yOne, xTwo, yTwo);
        contentStream.drawString("Hello");
        contentStream.endText();

        //begin to draw our line
        contentStream.drawLine(xOne, yOne - .5, xTwo, yYwo - .5);

        //close and save document
        document.save(file);
        document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
}