public void applyGrayscaleMaskToAlpha(BufferedImage image, BufferedImage mask)
{
    int width = image.getWidth();
    int height = image.getHeight();

    int[] imagePixels = image.getRGB(0, 0, width, height, null, 0, width);
    int[] maskPixels = mask.getRGB(0, 0, width, height, null, 0, width);

    for (int i = 0; i < imagePixels.length; i++)
    {
        int color = imagePixels[i] & 0x00ffffff; // Mask preexisting alpha

        // get alpha from color int
        // be careful, an alpha mask works the other way round, so we have to subtract this from 255
        int alpha = (maskPixels[i] >> 24) & 0xff;
        imagePixels[i] = color | alpha;
    }

    image.setRGB(0, 0, width, height, imagePixels, 0, width);
}