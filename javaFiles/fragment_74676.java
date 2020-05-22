private static PDDocument newDocument(final String text, final int offsetY) throws IOException, FontFormatException
{
    final PDDocument document = new PDDocument();
    document.addPage(insertTextInPage(document, text, offsetY));
    document.save("nul"); // NEW!
    return document;
}