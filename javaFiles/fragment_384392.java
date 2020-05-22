BufferedImage imagebuffer = ImageIO.read(new File("C:\\Users\\Ramandeep\\Downloads\\w3.jpg"));
iw = imagebuffer.getWidth();
ih = imagebuffer.getHeight();
BufferedImage image = new BufferedImage(iw,ih,BufferedImage.TYPE_INT_ARGB);
for (int x=0; x < iw; x++) {
     for (int y=0; y < ih; y++) {
          image.setRGB(x,y,imagebuffer.getRGB(x,y));
     }
}
ImageIO.write(image, "jpg", new File("C:\\Users\\Ramandeep\\Desktop\\out.jpg"));
ImageIO.write(image, "gif", new File("C:\\Users\\Ramandeep\\Desktop\\out.gif"));
ImageIO.write(image, "png", new File("C:\\Users\\Ramandeep\\Desktop\\out.png"));