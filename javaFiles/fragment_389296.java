BufferedImage createResizedCopy(BufferedImage img, int newW, int newH)
{
    BufferedImage scaledBI = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = scaledBI.createGraphics();
    g.setComposite(AlphaComposite.Src);
    g.drawImage(img, 0, 0, newW, newH, null); 
    g.dispose();
    return scaledBI;
}