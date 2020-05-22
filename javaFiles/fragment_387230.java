JLabel picLabel = new JLabel();
theGUI.add(picLabel);
while (true) 
{
    BufferedImage screenShot = robot.createScreenCapture(new Rectangle(1280,720));
    picLabel.setIcon(new ImageIcon(screenShot));   

}