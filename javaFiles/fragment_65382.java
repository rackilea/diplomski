ImageInputStream iis = ImageIO.createImageInputStream(new File("img/1.jpg"));
ImageOutputStream ios = ImageIO.createImageOutputStream(new File("img/new1.jpg"));

Integer b = null;
while ((b = iis.read()) != -1) {
  ios.write(b);

}