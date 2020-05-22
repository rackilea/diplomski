public static BufferedImage createTransparentMonochromeBufferedImage(int w, int h)
{
    // The color map contains the colors black and white
    byte[] cMap = {0, 0, 0, (byte)255, (byte)255, (byte)255};
    // Create an IndexColorModel setting white as the transparent color
    IndexColorModel monochrome = new IndexColorModel(8, 2, cMap, 0, false, 1);
    // Return a new BufferedImage using that color model 
    return new BufferedImage(w, h, BufferedImage.TYPE_BYTE_INDEXED, monochrome);
}