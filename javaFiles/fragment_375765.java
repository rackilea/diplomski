public SplashScreen()
{
    BufferedImage img = null;
    try {
        img = ImageIO.read(this.getClass().getResource("/res/ui/splashScreen.jpg"));
    } catch (Exception ex) {
    }

    ImgPanel panel = new ImgPanel(img);
    Container container = this.getContentPane();
    container.add(panel);
    pack();

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(screenSize.width/2 - (img.getWidth()/2), screenSize.height/2 - (img.getHeight()/2));

    this.setVisible(true);
 }