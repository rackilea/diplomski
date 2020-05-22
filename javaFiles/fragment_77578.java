int[] values = new int[eye.channels()];
for (int y = 0; y < eye.rows(); y++) {
  for (int x = 0; x < eye.cols(); x++) {
    eye.get(x, y, values);
    int value = values[0];

    // A loop not using ptr.
  }
}