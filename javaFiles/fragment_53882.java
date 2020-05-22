byte[] bytes = ...; // Your image bytes
OutputStream stream = ...; // Your output

BufferedImage image = createRGBImage(bytes, width, height);

try {
    ImageIO.write(image, "BMP", stream);
}
finally {
    stream.close();
}