public static void main(String[] args) {
    //Window
    JFrame mainWindow = new JFrame("Day One");
    mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    mainWindow.setUndecorated(true);

    //Create image
    JLabel imageHolder = new JLabel();
    imageHolder.setIcon(makeImageIcon("example.png"));

    //Add image to panel, add panel to frame
    JPanel panel = new JPanel();
    panel.add(imageHolder);

    mainWindow.add(panel);

    mainWindow.setVisible(true);
}

//Creates imageicont from filename
public static ImageIcon makeImageIcon(String filename) {
    BufferedImage myPicture = null;
    try {
        myPicture = ImageIO.read(new File("resources/" + filename));
    } catch (IOException e) {
        e.printStackTrace();
    }
    return new ImageIcon(myPicture);
}