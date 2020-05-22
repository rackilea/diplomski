private boolean needsRotate;

@Override
public Dimension getSize() {
  if (!needsRotate) {
    return super.getSize();
  }

  Dimension size = super.getSize();

  switch (getDirection()) {
  case VERTICAL_DOWN:
  case VERTICAL_UP:
      return new Dimension(size.height, size.width);
  default:
    return super.getSize();
  }
}

@Override
public int getHeight() {
  return getSize().height;
}

@Override
public int getWidth() {
  return getSize().width;
}

@Override
protected void paintComponent(Graphics g) {
  Graphics2D gr = (Graphics2D) g.create();

  switch (getDirection()) {
  case VERTICAL_UP:
    gr.translate(0, getSize().getHeight());
    gr.transform(AffineTransform.getQuadrantRotateInstance(-1));
    break;
  case VERTICAL_DOWN:
    gr.transform(AffineTransform.getQuadrantRotateInstance(1));
    gr.translate(0, -getSize().getWidth());
    break;
  default:
  }

  needsRotate = true;
  super.paintComponent(gr);
  needsRotate = false;
}