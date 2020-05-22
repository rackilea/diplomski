private synchronized BufferedImage getScaledImage1(BufferedImage imageBytes)
{
    BufferedImage scaledImage = null;
    int type = 0;
    try
    {
        type = imageBytes.getType();
        if(type == 0 || type ==6) {
            int w = imageBytes.getWidth();
            int h = imageBytes.getHeight();
            BufferedImage newImage = 
            new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D g = newImage.createGraphics();
            g.drawImage(imageBytes, 0, 0, null);
            g.dispose();
            imageBytes = newImage;
        }
        scaledImage = Scalr.resize(imageBytes, Scalr.Method.ULTRA_QUALITY,2000,
        Scalr.OP_ANTIALIAS);
    } catch(Exception e) {        
    }        
    return scaledImage;
}