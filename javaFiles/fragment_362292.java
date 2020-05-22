import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class BelishaBeacon {

    public class Drawing extends JPanel {

        private int x = 125;
        private int y = 80;
        private boolean changeColors = false;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            //creating the shapes
            Rectangle box1 = new Rectangle(165, 180, 20, 45);
            Rectangle box2 = new Rectangle(165, 225, 20, 45);
            Rectangle box3 = new Rectangle(165, 270, 20, 45);
            Rectangle box4 = new Rectangle(165, 315, 20, 45);
            Rectangle box5 = new Rectangle(165, 360, 20, 45);
            Rectangle box6 = new Rectangle(165, 405, 20, 45);
            //drawing the shapes
            Ellipse2D.Double ball = new Ellipse2D.Double(x, y, 100, 100);
            g2.draw(ball);
            g2.draw(box1);
            g2.draw(box2);
            g2.draw(box3);
            g2.draw(box4);
            g2.draw(box5);
            g2.draw(box6);
            //coloring the shapes
            g2.setColor(Color.BLACK);
            g2.fill(box1);
            g2.fill(box3);
            g2.fill(box5);
            g2.setColor(Color.YELLOW);
            g2.fill(ball);

            if (changeColors) {
                g2.setColor(Color.ORANGE);
                g2.fill(new Ellipse2D.Double(x, y, 100, 100));
            }

            changeColors = false;
        }

        public void changeColors() {
            changeColors = true;
            repaint();
        }
    }

    public BelishaBeacon() {
        //Creation of frame
        JFrame frame = new JFrame();
        frame.setSize(350, 570);
        frame.setTitle("Belisha Beacon");
        frame.setLayout(new BorderLayout(0, 0));
        final Drawing shapes = new Drawing();

        JButton jbtFlash = new JButton("Flash");
        final JButton jbtSteady = new JButton("Steady");
        jbtSteady.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        shapes.changeColors();
                    }
                });

        //Positioning
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 2, 0, 0));
        controlPanel.add(jbtFlash);
        controlPanel.add(jbtSteady);

        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.add(shapes);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BelishaBeacon();
    }
}