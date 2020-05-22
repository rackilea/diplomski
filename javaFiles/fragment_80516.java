// the path must be relative to your *class* files
String imagePath = "res/Image.png";
InputStream imgStream = Game.class.getResourceAsStream(imagePath );
BufferedImage myImg = ImageIO.read(imgStream);
// ImageIcon icon = new ImageIcon(myImg);

// use icon here
game.frame.setIconImage(myImg);