try {
    MediaTracker mt = new MediaTracker(new JPanel());
    Image image = Toolkit.getDefaultToolkit().createImage("...");
    mt.addImage(image, 0);
    System.out.println("Wait for...");
    mt.waitForAll();
    System.out.println("I be loaded");

    BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = bi.createGraphics();
    g2d.drawImage(image, 0, 0, null);
    g2d.dispose();
} catch (InterruptedException ex) {
    ex.printStackTrace();
}