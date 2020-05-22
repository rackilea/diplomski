public class TextAttributesSuperscript  {

    static int curX = 10;
    static int curY = 50;

    public static void main(String[] args) throws Exception {
        AttributedString attributedString = new AttributedString("this is data. this data should be super script");

        attributedString.addAttribute(TextAttribute.FONT, new Font("TimesRoman", Font.PLAIN, 18));
        attributedString.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);

        Font superScript = new Font("TimesRoman", Font.BOLD, 18)
                .deriveFont(Collections.singletonMap(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER));
        attributedString.addAttribute(TextAttribute.FONT, superScript, 30, 33);
        attributedString.addAttribute(TextAttribute.FOREGROUND, Color.BLUE, 30,33);

        BufferedImage image = new BufferedImage(400, 100, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g.setColor(Color.WHITE);

        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.drawString(attributedString.getIterator(), curX, curY);
        g.dispose();

        ImageIO.write(image, "png", new File("output.png"));
    }
}