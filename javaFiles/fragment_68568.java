public void rotateCW() {
    layout = "";
    initialPos = initialPos.next();
    int w = shape.length;
    int h = shape[0].length;

    swapped = new char[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        swapped[i][j] = shape[w - j - 1][i];
        layout += swapped[i][j];
      }
      layout += "\n";
    }
    height = swapped.length;
    width = swapped[0].length;
    shape = swapped;
  }