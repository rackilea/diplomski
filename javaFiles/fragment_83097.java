public P() {
    super();
    setSize(600, 350);  // not recommended
    buffer = new BufferedImage(600, 350, BufferedImage.TYPE_4BYTE_ABGR);
    Graphics bg = buffer.getGraphics();
    bg.setColor(Color.BLACK);
    bg.drawRect(0, 300, 300, 50);
    bg.dispose();

    // ....

}