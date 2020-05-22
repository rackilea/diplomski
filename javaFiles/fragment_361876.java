import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // Change these two lines to switch between the panels
                //frame.add(new Circle1());
                frame.add(new SliderPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Circle1 extends JPanel {

        private final CircleCanvas theCanvas;

        private final JTextArea display;

        public Circle1() {

            setLayout(new BorderLayout());

            theCanvas = new CircleCanvas();

            display = new JTextArea(4, 30);

            display.setText("The Radius: " + theCanvas.getRadius() + "\nThe Diameter: " + theCanvas.getDiameter() + "\nThe Area: " + theCanvas.getArea()
                            + "\nThe Circumference: " + theCanvas.getCircumference());

            add(theCanvas, BorderLayout.CENTER);
            add(display, BorderLayout.SOUTH);

        }

        void setDiameter(int value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        class CircleCanvas extends JPanel {

            private final int radius;

            public CircleCanvas() {

                radius = (int) (1 + Math.random() * 100);

            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawOval(0, 0, radius, radius);
            }

            public int getDiameter() {
                return (2 * radius);
            }

            public int getCircumference() {
                return (int) (2 * Math.PI * radius);
            }

            public int getArea() {
                return (int) (radius * radius * Math.PI);
            }

            public int getRadius() {
                return radius;
            }

        }
    }

    public class SliderPane extends JPanel {

        private JSlider diameterJSlider;
        private Circle1 myPanel;

        public SliderPane() {

            setLayout(new BorderLayout());

            myPanel = new Circle1();

            diameterJSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 300, 10);
            diameterJSlider.setMajorTickSpacing(10);
            diameterJSlider.setPaintTicks(true);
            diameterJSlider.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    myPanel.setDiameter(diameterJSlider.getValue());
                }
            }
            );
            add(diameterJSlider, BorderLayout.NORTH);
            add(myPanel, BorderLayout.CENTER);
        }
    }

}