public abstract class MyClass extends JPanel implements Printable{

    [...]

    public static enum Alignment {RIGHT, LEFT, CENTER};

    [...]

    /**
 * Draw paragraph.
 * Pinta un parrafo segun las localizaciones pasadas como parametros.
 *
 * @param g2 Drawing graphic.
 * @param text String to draw.
 * @param width Paragraph's desired width.
 * @param x Start paragraph's X-Position.
 * @param y Start paragraph's Y-Position.
 * @param dir Paragraph's alignment.
 * @return Next line Y-position to write to.
 */
protected float drawParagraph (Graphics2D g2, String text, float width, float x, float y, Alignment alignment){
    AttributedString attstring = new AttributedString(text);
    attstring.addAttribute(TextAttribute.FONT, font);
    AttributedCharacterIterator paragraph = attstring.getIterator();
    int paragraphStart = paragraph.getBeginIndex();
    int paragraphEnd = paragraph.getEndIndex();
    FontRenderContext frc = g2.getFontRenderContext();
    LineBreakMeasurer lineMeasurer = new LineBreakMeasurer(paragraph, frc);

    // Set break width to width of Component.
    float breakWidth = width;
    float drawPosY = y;
    // Set position to the index of the first character in the paragraph.
    lineMeasurer.setPosition(paragraphStart);

    // Get lines until the entire paragraph has been displayed.
    while (lineMeasurer.getPosition() < paragraphEnd) {
        // Retrieve next layout. A cleverer program would also cache
        // these layouts until the component is re-sized.
        TextLayout layout = lineMeasurer.nextLayout(breakWidth);
        // Compute pen x position. 
        float drawPosX;
        switch (alignment){         
        case RIGHT:
            drawPosX = (float) x + breakWidth - layout.getAdvance();
            break;
        case CENTER:
            drawPosX = (float) x + (breakWidth - layout.getAdvance())/2;
            break;
        default: 
            drawPosX = (float) x;
        }
        // Move y-coordinate by the ascent of the layout.
        drawPosY += layout.getAscent();

        // Draw the TextLayout at (drawPosX, drawPosY).
        layout.draw(g2, drawPosX, drawPosY);

        // Move y-coordinate in preparation for next layout.
        drawPosY += layout.getDescent() + layout.getLeading();
    }
    return drawPosY;
}
}