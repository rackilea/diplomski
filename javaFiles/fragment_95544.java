BufferedImage image = null; // you have the data in this object
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(image, "fileformat like png or jpg", baos);
baos.flush();
byte[] imageInByte = baos.toByteArray(); // you have the data in byte array
baos.close();