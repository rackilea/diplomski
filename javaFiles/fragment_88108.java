public void setWidth(int w) {
    System.out.println("setWidth " + w);
    this.width = w;
    circle.setFrame(100, 20, w, 300);
    revalidate();
    repaint();
}