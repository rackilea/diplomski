MyWindow theWindow = new MyWindow();

Graphics g = theWindow.thePanel.getGraphics();
BufferedImage someRandomImage = SomeRandomClass.getRandomImage();
g.drawImage(someRandomImage, 200, 481, null);

theWindow.repaintWindow();