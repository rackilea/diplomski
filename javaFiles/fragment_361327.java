ImageInputStream input = ImageIO.createImageInput(new File("/path/thumbs.db"));
ImageReader reader = ImageIO.getImageReaders(input).next();
reader.setInput(input);

for (int i = 0; i < reader.getNumImages(); i++) {
    BufferedImage thumb = reader.getImage(i, null);

    // do something with it...
}

reader.dispose(); // These last two, preferably in a finally block or "try-with-resource"
input.close();