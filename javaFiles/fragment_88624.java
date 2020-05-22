public static void main(String[] args) throws IOException {

    // create a temp file to hold the output
    File outputFile = File.createTempFile("stackoverflow",".pdf");

    PdfDocument pdfDocument =  new PdfDocument(new PdfWriter(outputFile));
    Document layoutDocument = new Document(pdfDocument);

    String[] lines = {"Hi","StackOverflow","I'd like","this","text","to","be","closer","together!"};
    for(String line : lines){
        layoutDocument.add(new Paragraph(line)
                .setMultipliedLeading(0.5f));   // this is where the magic happens
    }

    layoutDocument.close();
    pdfDocument.close();

    // display the temp file with the default PDF viewer
    Desktop.getDesktop().open(outputFile);
}