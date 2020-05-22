public class TextOverlayer {

    public static void main(String[] args) throws IOException {

        // Instantiate a TextOverlayer and read a source/input image from disk
        TextOverlayer textOverlayer = new TextOverlayer();
        BufferedImage bufferedImage = ImageIO.read(Paths.get("/User/myuser/pix/sourceImage.jpg").toFile());

        // Lay some text over the image at specific coordinates
        BufferedImage drawn = textOverlayer.drawText(bufferedImage, "Some text");

        // Write the overlayed image to disk
        File outputfile = new File("/User/myuser/pix/targetImage.jpg");
        boolean result = ImageIO.write(drawn, "jpg", outputfile);
        if (!result) {
            System.out.println("FAILED");
        }
    }

    private BufferedImage drawText(BufferedImage old, String text) {

        int w = old.getWidth();
        int h = old.getHeight();
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.drawImage(old, 0, 0, w, h, null);
        g2d.setPaint(Color.red);
        g2d.setFont(new Font("Serif", Font.BOLD, 20));
        FontMetrics fm = g2d.getFontMetrics();
        int x = img.getWidth() - fm.stringWidth(text) - 5;
        int y = fm.getHeight();
        g2d.drawString(text, x, y);
        g2d.dispose();

        return img;

    }
}