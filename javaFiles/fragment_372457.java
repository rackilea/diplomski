private void saveView(File saveTo, JPanel view) {

    BufferedImage image = new BufferedImage(view.getPreferredSize().width,
        view.getPreferredSize().height,
        BufferedImage.TYPE_4BYTE_ABGR);

    view.print(image.getGraphics());

    try {
        ImageIO.write(image, "png", saveTo);
    } catch (IOException e) {
        //Handle exception
    }
}