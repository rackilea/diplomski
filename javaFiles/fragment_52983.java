Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
BufferedImage screenCapture = new Robot().createScreenCapture(screen);

Image cursor = ImageIO.read(new File("c:/cursor.gif"));
int x = MouseInfo.getPointerInfo().getLocation().x;
int y = MouseInfo.getPointerInfo().getLocation().y;

Graphics2D graphics2D = screenCapture.createGraphics();
graphics2D.drawImage(cursor, x, y, 16, 16, null); // cursor.gif is 16x16 size.
ImageIO.write(screenCapture, "GIF", new File("c:/capture.gif"));