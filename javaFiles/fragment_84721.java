public void paint(Graphics g) {
    Image dbImg = createImage(getWidth(), getHeight());
    Graphics dbg = dbImg.getGraphics();
    draw(dbg);
    g.drawImage(dbImg, 0, 0, this);
}