public static final float calculateFontSize(String fontName, float maxFontsize, float width, float height, String text) {
    Font font = FontFactory.getFont(fontName);
    Rectangle rectangle = new Rectangle(width, height);
    System.err.println("Calculating font size for " + width + " and " + height);
    return PdfSignatureAppearance.fitText(font, text, rectangle, maxFontsize, PdfWriter.RUN_DIRECTION_LTR);
}