String path = String.format("/img/32px-Shuffle%03d", i);
URL resource = getClass().getResource(path);
if (resource != null) {
    BufferedImage img = ImageIO.read(resource);
    selectionClicky.setIcon(new ImageIcon(img));
}