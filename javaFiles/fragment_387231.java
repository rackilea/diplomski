public class ScreenShotPanel extends JLabel
{

    @override
    public void paintComponent(Graphics g) {
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(1280,720));
        g.drawImage(screenShot,0,0,this);
    }
}