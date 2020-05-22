public Image getImage(final PdfContentByte contentByte) throws Exception {
    final Paragraph paragraph = this.getParagraph();
    final Rectangle paragraphRectangle = this.getParagraphRectangle();
    final float paragraphHeight = paragraphRectangle.getHeight();
    final float paragraphWidth = paragraphRectangle.getWidth();

    final PdfTemplate xObject = contentByte.createTemplate(paragraphWidth, paragraphHeight + this.getFontSize());
    final ColumnText column = new ColumnText(xObject);
    column.setSimpleColumn(0, 0, paragraphWidth, paragraphHeight);
    column.setExtraParagraphSpace(0f);
    column.addElement(paragraph);
    column.go();

    final Image img = Image.getInstance(xObject);
    final int rotation = this.getRotation();
    img.setRotationDegrees(rotation);
    return img;
}

public Rectangle getParagraphRectangle(final WatermarkPosition position, Paragraph para) throws Exception {
    int numberOfLines = 1;
    float paragraphWidth = 0f;
    float paragraphHeight = 0f;
    float leading = 0f;
    float chunkFontSize = 0f;
    float currentChunkWidth = 0f;
    float currentChunkHeight = 0f;
    Font f = null;
    BaseFont bf = null;
    String content = null;

    List<Chunk> chunks = this.fontSelectorPhrase.getChunks();
    for(Chunk c : chunks) {
        f = c.getFont();
        bf = f.getBaseFont();
        content = c.getContent();
        chunkFontSize = f.getSize();
        currentChunkWidth = bf.getWidthPoint(" " + content + " ", chunkFontSize);

        currentChunkHeight = chunkFontSize + bf.getAscentPoint(content, chunkFontSize) - bf.getDescentPoint(content, chunkFontSize);

        if(!c.getContent().contains(System.getProperty("line.separator"))) {
            paragraphWidth += currentChunkWidth > paragraphWidth ? currentChunkWidth : paragraphWidth;
        } else {
            paragraphWidth = currentChunkWidth;
            numberOfLines++;
        }

        paragraphHeight = currentChunkHeight > paragraphHeight ? currentChunkHeight : paragraphHeight;

        leading = chunkFontSize > leading ? chunkFontSize : leading; 
    }

    para.setLeading(leading);

    paragraphHeight += (leading * numberOfLines);

    return new Rectangle(paragraphWidth, paragraphHeight);
}