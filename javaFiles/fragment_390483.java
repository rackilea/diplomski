BufferedImage result = ...

ImageWriter writer = ImageIO.getImageWritersByFormatName("jpeg").next();
ImageWriteParam param = writer.getDefaultWriteParam();
param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);

...

writer.setOutput(...);
writer.write(null, new IIOImage(result, null, null), param); // nulls are metadata and thumbnails, don't worry :-)