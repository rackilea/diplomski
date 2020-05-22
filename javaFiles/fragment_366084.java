public class DrawStringExample {

    private static Font FONT = new Font("Verdana", Font.BOLD, 28);

    public DrawStringExample() {
        MarvinImage image = MarvinImageIO.loadImage("./res/Parts1_output.jpg");
        MarvinSegment segment = new MarvinSegment(537, 26, 667, 96);
        drawStringMarvin("bolt", segment, image);
        MarvinImageIO.saveImage(image, "./res/Parts1_output_2.jpg");
    }

    private void drawStringMarvin(String text, MarvinSegment segment, MarvinImage image) {
        BufferedImage bufImage = image.getBufferedImageNoAlpha();
        Graphics2D g2d = (Graphics2D)bufImage.getGraphics();
        g2d.setFont(FONT);
        g2d.drawString(text, segment.x1, segment.y1+FONT.getSize());
        image.setBufferedImage(bufImage);   
    }

    public static void main(String[] args) {
        new DrawStringExample();
    }
}