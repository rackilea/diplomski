@Override
public Dimension getPreferredSize() {
  if (bg == null) {
    return super.getPreferredSize();
  } else {
    return new Dimension(bg.getWidth(), bg.getHeight());
  }
}