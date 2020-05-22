final BufferedImage image = // your image;
final Set<Integer> colours = new HashSet<Integer>();

for (int x = 0; x < image.getWidth(); x++) {
  for (int y = 0; y < image.getHeight(); y++) {
    colours.add(image.getRGB(x, y));
  }
}

// Check your pixels here. In grayscale images the R equals G equals B