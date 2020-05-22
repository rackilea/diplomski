try (InputStream is = getClass.getClassLoader().getResourcesAsStream("directory/image.jpg")) { 
    BufferedImage image = ImageIO.read(is);
    return new JButton("Text", new ImageIcon(image));
} catch (IOException exc) {
    throw new RuntimeException(exc);
}