public static byte[] imageToByteArray(BufferedImage image) throws IOException
{
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(image, "png", baos);
    return baos.toByteArray();
}

/*
public static BufferedImage byteArrayToImage(byte[] imageArray) throws IOException
{
    return ImageIO.read(new ByteArrayInputStream(imageArray));
}
*/