double[] coords = new double[2];
for (int i = 0; i < h; i++) {
  for (int j = 0; j < w; j++) {
    coords[0] = i;
    coords[1] = j;
    final int nearest = kd.nearest(coords);
    final Color c = new Color(img.getRGB(j, i));
    totalBlue[nearest] += c.getBlue();
    totalRed[nearest] += c.getRed();
    totalGreen[nearest] += c.getGreen();
    counter_sec[nearest]++;
  }
}