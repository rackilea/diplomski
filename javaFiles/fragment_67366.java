public static void combine()
{
    try{
              File path = new File("D:/proj2/javacv2");

    // load source images

      BufferedImage image = ImageIO.read(new File(path, "3.jpg"));

      BufferedImage overlay = ImageIO.read(new File(path, "test4a.png"));

     // BufferedImage image=src.getBufferedImage();
   // BufferedImage overlay =tmp.getBufferedImage();
    // create the new image, canvas size is the max. of both image sizes
    int w = Math.max(image.getWidth(), overlay.getWidth());
    int h = Math.max(image.getHeight(), overlay.getHeight());
      //int w=tmp.width();
     // int h=tmp.height();
    BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

    // paint both images, preserving the alpha channels
    Graphics g = combined.getGraphics();
    g.drawImage(image, 0, 0, null);
    g.drawImage(overlay, 41, 30, null);

    // Save as new image

       ImageIO.write(combined, "PNG", new File(path, "combined.png"));
    }catch(Exception e)
    {
        System.out.println("exception ");
    }

}