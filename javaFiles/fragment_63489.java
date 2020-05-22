public static void main(String[] a) throws Exception {

    final JFrame frame = new JFrame("My Frame");
    frame.getContentPane().setBackground(Color.CYAN);
    frame.setSize(400, 400);
    frame.setVisible(true);

    final BufferedImage image = new BufferedImage(frame.getWidth(),
            frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
    frame.paint(image.getGraphics());
    File outputfile = new File("C:/Temp/frame.png");
    ImageIO.write(image, "png", outputfile);
}