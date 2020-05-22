public static void main(String[] args) throws Exception
{
    final String imageFile = "/tmp/page0.png";

    final BufferedImage pngImage = ImageIO.read(new File(imageFile));

    // convert PNG to JPEG
    // http://www.mkyong.com/java/convert-png-to-jpeg-image-file-in-java/
    final BufferedImage rgbImage = new BufferedImage(pngImage.getWidth(), pngImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
    rgbImage.createGraphics().drawImage(pngImage, 0, 0, Color.WHITE, null);

    // RGB to CMYK using ColorConvertOp
    // http://stackoverflow.com/questions/380678/how-to-set-icc-color-profile-in-java-and-change-colorspace/2804370#2804370
    final ICC_Profile ip = ICC_Profile.getInstance("icc/USWebUncoated.icc");

    final ColorConvertOp cco = new ColorConvertOp(rgbImage.getColorModel().getColorSpace(), new ICC_ColorSpace(ip), null);

    final BufferedImage cmykImage = new BufferedImage(pngImage.getWidth(), pngImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

    cco.filter(rgbImage, cmykImage);

    // Write the result into an bytearray
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(cmykImage, "JPEG", baos);
    baos.flush();
}