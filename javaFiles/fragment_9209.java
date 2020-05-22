img = ImageIO.read(new File("/Users/mathewlewis/desktop/pic.jpg"));

BufferedImage rgbImage = new BufferedImage(img.getWidth(), img.getHeight(),
BufferedImage.TYPE_3BYTE_BGR);
ColorConvertOp op = new ColorConvertOp(null);
op.filter(img, rgbImage);

String width = "" + rgbImage.getWidth();
String height = "" + rgbImage.getHeight();
System.out.println("heigth = " + height + " and width = " + width);

BufferedImage crp = rgbImage.getSubimage(300,300,rgbImage.getWidth()-300,rgbImage.getHeight()-300);