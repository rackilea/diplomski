@Override
public void paintComponent (Graphics g)
{
    BufferedImage localFrontImage;
    synchronized (this)
    {
        localFrontImage = mFrontImage;
    }
    if (localFrontImage == null)
        super.paintComponent (g);
    else
        g.drawImage (localFrontImage, 0, 0, null);

}