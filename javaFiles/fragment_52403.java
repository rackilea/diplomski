public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
    ParagraphBorder border = new ParagraphBorder();
    writer.setPageEvent(border);
    document.open();
    document.add(new Paragraph("Hello,"));
    document.add(new Paragraph("In this document, we'll add several paragraphs that will trigger page events. As long as the event isn't activated, nothing special happens, but let's make the event active and see what happens:"));
    border.setActive(true);
    document.add(new Paragraph("This paragraph now has a border. Isn't that fantastic? By changing the event, we can even provide a background color, change the line width of the border and many other things. Now let's deactivate the event."));
    border.setActive(false);
    document.add(new Paragraph("This paragraph no longer has a border."));
    document.close();
}