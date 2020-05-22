BufferedImage[] images = ...
OutputStream stream = ... // May also use File here, as output

// Obtain a TIFF writer
ImageWriter writer = ImageIO.getImageWritersByFormatName("TIFF").next();

try (ImageOutputStream output = ImageIO.createImageOutputStream(stream)) {
    writer.setOutput(output);

    ImageWriteParam params = writer.getDefaultWriteParam();
    params.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);

    // Compression: None, PackBits, ZLib, Deflate, LZW, JPEG and CCITT variants allowed
    // (different plugins may use a different set of compression type names)
    params.setCompressionType("Deflate");

    writer.prepareWriteSequence(null);

    for (BufferedImage image : images) {
        writer.writeToSequence(new IIOImage(image, null, null), params);
    }

    // We're done
    writer.endWriteSequence();
}

writer.dispose();