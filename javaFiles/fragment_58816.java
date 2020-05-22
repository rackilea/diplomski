public void convertFromClob(Clob c, File f2) {
    try {
        InputStream inStream = c.getAsciiStream();
        StringWriter sw = new StringWriter();
        IOUtils.copy(inStream, sw);

        // Transfer the data
        byte[] data = Base64.decodeBase64(sw.toString());
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(data));
        ImageIO.write(image, "png", f2);

    } catch (Exception e) {
        e.printStackTrace();
    }
}