BufferedImage bufferedImage = new Robot().createScreenCapture(new Rectangle(startX, startY, width, height));
ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
ImageIO.write(bufferedImage, format, outputStream);
outputStream.flush();
byte[] data = outputStream.toByteArray();
outputStream.close();