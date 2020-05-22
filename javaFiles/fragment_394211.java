static Shape[] getGlyphShapes(Font font, String strGlyphs, AffineTransform transform) {

    FontRenderContext frc = new FontRenderContext(null, true, true);
    GlyphVector glyphs = font.createGlyphVector(frc, strGlyphs);

    int count = glyphs.getNumGlyphs();
    Shape[] shapes = new Shape[count];
    for (int i = 0; i < count; i ++) {

        // get transformed glyph shape
        GeneralPath path = (GeneralPath) glyphs.getGlyphOutline(i);
        shapes[i] = path.createTransformedShape(transform);
    }
    return shapes;

}