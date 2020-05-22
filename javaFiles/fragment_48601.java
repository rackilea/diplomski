byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64Image);
BufferedImage img = ImageIO.read(new 
   ByteArrayInputStream(imageBytes));
String imageId = generateRandomKey(15);

// re-encode
ImageIO.write(img, "png", getImageFile(imageId));