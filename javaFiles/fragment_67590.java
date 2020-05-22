ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

JPEGImageEncoder imageEncoder = JPEGCodec.createJPEGEncoder(outputStream);
imageEncoder.encode(bufferedImage);

byte[] bytes = outputStream.toByteArray();
InputStream inputStream = new ByteArrayInputStream(bytes);