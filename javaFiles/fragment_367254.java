import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseTrackingSmilieFace extends JFrame {

    private int a;
    private int b;

    private JPanel smilieFacePanel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawArc(100, 50, 150, 150, 0, 360);
            g.drawArc(125, 65, 40, 40, 0, 360);
            g.drawArc(180, 65, 40, 40, 0, 360);
            g.drawArc(165, 105, 15, 15, 60, 180);
            g.fillOval(a, b, 15, 15);
            g.fillOval(a+55, b, 15, 15);
            // Register the motion listener
            addMouseMotionListener(new MouseMotionListener() {

                // Do the same thing whether the mouse button is depressed...
                public void mouseDragged(MouseEvent e) {
                    processMovement(e);
                }

                // ... or not.
                public void mouseMoved(MouseEvent e) {
                    processMovement(e);
                }

                /* Process the movement by capturing the x coordinate of the mouse in member variable 'a'
                 * and the y coordinate in member variable 'b'.
                 */
                private void processMovement(MouseEvent e) {
                    a = e.getX();
                    b = e.getY();
                    System.out.println("X = " + a + " Y = " + b);
                    smilieFacePanel.repaint();
                }
            });
        }
    };

    private MouseTrackingSmilieFace() {
        // Invoke the JFrame superclass constructor and configure the frame
        super("Mouse-tracking smilie face");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
        // Add a panel to the frame and draw the face within it.
        this.add(smilieFacePanel);
    }

    public static void main(String[] args) {
        // Create on the Event Dispatch Thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MouseTrackingSmilieFace();
            }
        });
    }
}