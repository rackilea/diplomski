for (int r = 0; r < shape.length; ++r) {
  for (int c = 0; c < shape[r].length; ++c) {
    if (shape[r][c] != 0) {
      targetArea.add(new Point(x + c, y + r));
    }
  }
}