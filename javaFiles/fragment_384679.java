protected void showGlyph(Matrix textRenderingMatrix, PDFont font, int code, String unicode, Vector displacement) throws IOException
{
    super.showGlyph(textRenderingMatrix, font, code, unicode, displacement);
    if (unicode == null || unicode.isEmpty())
    {
        // do stuff
    }
}