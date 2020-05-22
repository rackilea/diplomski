Collections.sort(colors, new Comparator<Color>() {
  @Override
  public int compare(Color c1, Color c2) {
    return Integer.compare(c1.getRed() + c1.getGreen() + c1.getBlue(), c2.getRed() + c2.getGreen() + c2.getBlue());
  }
});