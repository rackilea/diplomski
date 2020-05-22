BufferedImage img = null;
try {
   img = ImageIO.read(new File ("c:/imageFile.gif"));
} catch(Exception e) {}

Raster R=img.getData();