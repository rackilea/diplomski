BufferedImage buf_image; // this is BufferedImage reference you got after converting it from Image
byte[] imageByteArray = bufferedImageToByteArray(buf_image,"jpg");

public static byte[] bufferedImageToByteArray(BufferedImage image, String format) throws IOException
{
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(image, format, baos);
    return baos.toByteArray();
}