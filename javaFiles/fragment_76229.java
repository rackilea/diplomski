Image getThumbnail(File file) {

  BufferedImage original = ImageIO.read(file);
  //assuming we want a square thumbnail here
  int side = Math.min(original.getWidth(), original.getHeight());

  int x = (original.getWidth() - side) / 2;
  int y = (original.getHeight() - side) / 2;

  BufferedImage cropped = original.getSubimage(x, y, side, side);
  return cropped.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
}