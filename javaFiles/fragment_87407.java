private byte[] createBytesFromImage(BufferedImage image) {
    try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ImageIO.write(image,"png",baos);

        byte[] imageBytes = baos.toByteArray();
        baos.close();
        return imageBytes;

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}