public void paintControl(PaintEvent event) {

  GC gc = event.gc;

  gc.setBackground(... background color ...);

  Rectangle fillRect = getClientArea();

  gc.fillRectangle(fillRect);

  ... continue drawing
}