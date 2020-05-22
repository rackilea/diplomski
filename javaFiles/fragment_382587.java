ImageReader reader;
reader.setInput(input);

IIOImage image = reader.readAll(0, null); // Read image and metadata in one go

doStuffWithImage(image.getRenderedImage()); // Most likely safe to cast to BufferedImage

ImageWriter writer = ImageIO.getImageWriter(reader);
writer.setOutput(output);

ImageWriteParam param = writer.getDefaultWriteParam();

// According to the API doc, the default compressionMode is
// MODE_COPY_FROM_METADATA which is what we want :-)

writer.write(null, image, param); // Don't need stream metadata for TIFF