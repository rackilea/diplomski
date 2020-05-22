import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** @see https://stackoverflow.com/a/20556929/230513 */
public class QuadraticSlider {

    private static final int N = 500;
    private static final int A = 1;
    private static final int B = 0;
    private static final int C = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Quadratic Slider");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new QuadraticPanel());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private static class QuadraticPanel extends JPanel {

        private Box controls;
        private JPanel graphPanel;
        private JSlider aSlider, bSlider, cSlider;
        private JLabel aLabel, bLabel, cLabel;
        double a, b, c, x, y;

        public QuadraticPanel() {
            aSlider = new JSlider(JSlider.HORIZONTAL, -25, 25, A);
            aSlider.setMajorTickSpacing(10);
            aSlider.setMinorTickSpacing(5);
            aSlider.setPaintTicks(true);
            aSlider.setPaintLabels(true);
            aSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

            bSlider = new JSlider(JSlider.HORIZONTAL, -10, 10, B);
            bSlider.setMajorTickSpacing(5);
            bSlider.setMinorTickSpacing(1);
            bSlider.setPaintTicks(true);
            bSlider.setPaintLabels(true);
            bSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

            cSlider = new JSlider(JSlider.HORIZONTAL, -100, 100, C);
            cSlider.setMajorTickSpacing(50);
            cSlider.setMinorTickSpacing(10);
            cSlider.setPaintTicks(true);
            cSlider.setPaintLabels(true);
            cSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

            SliderListener listener = new SliderListener();
            aSlider.addChangeListener(listener);
            bSlider.addChangeListener(listener);
            cSlider.addChangeListener(listener);

            aLabel = new JLabel("a: 0");
            bLabel = new JLabel("b: 0");
            cLabel = new JLabel("c: 0");
            controls = new Box(BoxLayout.Y_AXIS);
            controls.add(aLabel);
            controls.add(aSlider);
            controls.add(Box.createRigidArea(new Dimension(0, 20)));
            controls.add(bLabel);
            controls.add(bSlider);
            controls.add(Box.createRigidArea(new Dimension(0, 20)));
            controls.add(cLabel);
            controls.add(cSlider);

            graphPanel = new JPanel() {
                private static final int SCALE = 5;
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(N, N);
                }

                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    for (x = -10; x <= 10; x++) {
                        y = a * x * x + b * x + c;
                        g.setColor(Color.black);
                        int w = (int) (x * SCALE) + N / 2;
                        int h = (int) (-y * SCALE) + N / 2;
                        g.fillOval(w, h, 5, 5);
                    }
                }
            };
            graphPanel.setBackground(Color.white);

            add(controls);
            add(graphPanel);
            listener.stateChanged(null);
        }

        class SliderListener implements ChangeListener {

            @Override
            public void stateChanged(ChangeEvent event) {
                a = aSlider.getValue() / 5d;
                b = bSlider.getValue();
                c = cSlider.getValue();

                aLabel.setText("a: " + a);
                bLabel.setText("b: " + b);
                cLabel.setText("c: " + c);

                repaint();
            }
        }
    }
}