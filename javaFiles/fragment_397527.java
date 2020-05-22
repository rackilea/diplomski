public BufferedImage combineMasks(BufferedImage[] images)
{
    // create the new image, canvas size is the max. of all image sizes
    int w, h;

    for (BufferedImage img : images)
    {
        w = img.getWidth() > w ? img.getWidth() : w;
        h = img.getHeight() > h ? img.getHeight() : h;
    }

    BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

    // paint all images, preserving the alpha channels
    Graphics g = combined.getGraphics();

    for (BufferedImage img : images)
        g.drawImage(img, 0, 0, null);

    return combined;
}