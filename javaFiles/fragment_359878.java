import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DemoRobotPanel extends JPanel{
    private static final long serialVersionUID = 1L;

    private Image image;
    private Robot robot;
    private Rectangle CAPTURE_RECT;
    private int TIMER_DELAY = 1000;
    private int desiredWidth = 600;
    private int desiredHeight = 400;

    public DemoRobotPanel() {
        CAPTURE_RECT = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        try {
            robot = new Robot();

            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    try {
                        BufferedImage img = robot.createScreenCapture(CAPTURE_RECT);
                        setImage(img);
                    } catch (HeadlessException e) {
                        e.printStackTrace();
                    }
                }
            };

            Timer timer = new Timer(TIMER_DELAY, taskPerformer);
            timer.start();

        } catch (AWTException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(desiredWidth, desiredHeight);
    }

    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    private static void createAndShowGui()  {
        final DemoRobotPanel panel = new DemoRobotPanel();
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}