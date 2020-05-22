public int[] searchForColor(BufferedImage bi, int searchColor)
{
    for (int x = 0; x < bi.getWidth(); ++x)
    for (int y = 0; y < bi.getHeight(); ++y)
    {
        if ((bi.getRGB(x, y) & 0x00FFFFFF) == searchColor)
            return new int[]{x, y};
    }
}