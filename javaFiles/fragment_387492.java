import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingDemo extends JPanel {
    private static final int DIM_WIDTH = 500;
    private static final int DIM_HEIGHT = 500;


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.BLUE);
        g2.fillRect(100, 100, 200, 200);
    }

    public static void createAndShowGui(){
        JFrame frame = new JFrame();
        frame.add(new SwingDemo());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);

    }

    public Dimension getPreferredSize(){
        return new Dimension(DIM_WIDTH, DIM_HEIGHT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGui();
            }
        });
    }
}