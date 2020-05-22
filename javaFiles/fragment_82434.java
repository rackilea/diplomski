try {
    OutputStream outputStream = client.socket.getOutputStream();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
    // get the size of image
    byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
    outputStream.write(size);
    outputStream.write(byteArrayOutputStream.toByteArray());
    outputStream.flush();
} catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}