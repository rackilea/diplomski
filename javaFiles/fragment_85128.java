//Design the rectangle 
Component c = somecomponent;
Rectangle rect = new Rectangle(c.getLocation(), c.getSize());

   //Get the ScreenShot
   Robot robot = new Robot();
   BufferedImage image = robot.createScreenCapture(rect);
   ImageIO.write(image, "png", new File(fileName));