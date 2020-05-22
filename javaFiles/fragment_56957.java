BufferedImage image = ImageIO.read(new File("C:\\Downloads\\sandal.tif"));

ICC_ColorSpace ics = (ICC_ColorSpace) ColorSpaces.getColorSpace(ColorSpaces.CS_ADOBE_RGB_1998);
ColorConvertOp cco = new ColorConvertOp(ics, null);
BufferedImage result = cco.filter(image, null);

File tempFile = File.createTempFile("test-", ".tif");
System.out.println("tempFile: " + tempFile); // Just to know where to look
ImageIO.write(result, "TIFF", tempFile);