try (ImageInputStream input = ImageIO.createImageInputStream(new File("C:\\Downloads\\sandal.tif"))) {
    ImageReader reader = ImageIO.getImageReaders(input).next();
    reader.setInput(input);
    IIOImage imageAndMeta = reader.readAll(0, reader.getDefaultReadParam());
    reader.dispose();

    ICC_ColorSpace ics = (ICC_ColorSpace) ColorSpaces.getColorSpace(ColorSpaces.CS_ADOBE_RGB_1998);
    ColorConvertOp cco = new ColorConvertOp(ics, null);
    BufferedImage result = cco.filter((BufferedImage) imageAndMeta.getRenderedImage(), null);

    imageAndMeta.setRenderedImage(result);

    File tempFile = File.createTempFile("test-", ".tif");
    System.err.println("tempFile: " + tempFile);

    ImageWriter tiffWriter = ImageIO.getImageWritersByFormatName("TIFF").next();
    try (ImageOutputStream stream = ImageIO.createImageOutputStream(tempFile)) {
        tiffWriter.setOutput(stream);

        ImageWriteParam writeParam = tiffWriter.getDefaultWriteParam();

        // If you want a specific compression, uncommment these lines
        // The default setting is to copy from metadata
//        writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        // Allowed compression type values are: 
        // "None", "CCITT RLE", "CCITT T.4", "CCITT T.6","LZW", "JPEG", "ZLib", "PackBits" and "Deflate"
//        writeParam.setCompressionType("PackBits");

        tiffWriter.write(null, imageAndMeta, writeParam);
    }

    tiffWriter.dispose();
}