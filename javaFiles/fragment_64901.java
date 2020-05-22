byte[] fontBytes = null;
try (   InputStream arialMtResource = getClass().getResourceAsStream("ArialMT.ttf");
        ByteArrayOutputStream baos = new ByteArrayOutputStream()   )
{
    patchAdvanceWidth(arialMtResource, baos, 101-29, 2000);
    fontBytes = baos.toByteArray();
}

try (   ByteArrayInputStream fontStream = new ByteArrayInputStream(fontBytes);   )
{
    PDDocument doc = new PDDocument();
    PDPage page = new PDPage();
    doc.addPage(page);
    PDFont font = PDTrueTypeFont.loadTTF(doc, fontStream);
    PDPageContentStream stream = new PDPageContentStream(doc, page);
    stream.setFont(font, 12);
    stream.beginText();
    stream.moveTextPositionByAmount(30, 600);
    stream.drawString("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    stream.moveTextPositionByAmount(0, -20);
    stream.drawString("abcdefghijklmnopqrstuvwxyz");
    stream.moveTextPositionByAmount(0, -20);
    stream.drawString("0123456789");
    stream.endText();
    stream.close();

    doc.save("target/test-outputs/embedPatchedFont.pdf");
}