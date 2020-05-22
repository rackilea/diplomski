ImageWriter writer = ImageIO.getImageWritersByFormatName("TIFF").next();
writer.setOutput(stream);

ImageWriteParam param = writer.getDefaultWriteParam();
param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
param.setCompressionType("LZW"); // "Zlib", "PackBits", "JPEG", "CCITT T.4", "CCITT T.6" etc.
param.setCompressionQuality(0.5f); // Applies only to some compression types. Generally:
                                   // * 0.0 means highest compression
                                   // * 1.0 means best quality