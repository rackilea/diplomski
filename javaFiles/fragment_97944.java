private static void cutAPDPage(int nbOfCrops, PDPage myPage, int resize) throws IOException{
    PDDocument pdfSplit = new PDDocument();
    ArrayList<PDPage> pages = new ArrayList<PDPage>();

    PDRectangle cropBox = myPage.findCropBox();
    PDRectangle newCropBox = new PDRectangle();
    newCropBox.setLowerLeftX(cropBox.getLowerLeftX());
    newCropBox.setLowerLeftY(cropBox.getLowerLeftY() - resize);
    newCropBox.setUpperRightX(cropBox.getUpperRightX());
    newCropBox.setUpperRightY(cropBox.getUpperRightY() + resize);
    myPage.setCropBox(newCropBox);


    PDRectangle mediaBox = myPage.findMediaBox();
    PDRectangle newMediaBox = new PDRectangle();
    newMediaBox.setLowerLeftX(mediaBox.getLowerLeftX());
    newMediaBox.setLowerLeftY(mediaBox.getLowerLeftY() - resize);
    newMediaBox.setUpperRightX(mediaBox.getUpperRightX());
    newMediaBox.setUpperRightY(mediaBox.getUpperRightY() + resize);
    myPage.setMediaBox(newMediaBox);

    float croppingHeight = (myPage.findCropBox().getUpperRightY()/nbOfCrops);

    for(int page = 0; page<nbOfCrops; page++){
        pages.add(new PDPage());
    }
    int splits = 0;
    for(PDPage page: pages){
        page = (PDPage) pdf.importPage(myPage);
        PDRectangle cropBox1 = page.findCropBox();
        PDRectangle rectangle = new PDRectangle();

        rectangle.setUpperRightY((float) (cropBox1.getUpperRightY() - (croppingHeight * (splits))));
        rectangle.setLowerLeftY((float) (cropBox1.getUpperRightY() - (croppingHeight*(splits + 1))));
        rectangle.setUpperRightX(cropBox1.getUpperRightX());
        rectangle.setLowerLeftX(cropBox1.getLowerLeftX());
        page.setCropBox(rectangle);

        pdfSplit.addPage(page);

        splits++;
    }
    try {
        pdfSplit.save("split.pdf");   
        pdfSplit.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}