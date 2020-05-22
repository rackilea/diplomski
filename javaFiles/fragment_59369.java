// Load the font, for example "Telugu.ttf"
String fName = "/fonts/" + name;
InputStream is = null;
try {
    InputStream is = DemoFonts.class.getResourceAsStream(fName);
    font = Font.createFont(Font.TRUETYPE_FONT, is);
} finally {
    try {
        is.close();
    } catch (Exception exp) {
    }
}