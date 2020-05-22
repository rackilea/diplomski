import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

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

                JFrame frame = new JFrame();
                frame.setSize(400, 400);
                //      frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                GraphPanel gPane = new GraphPanel(3, frame);
                frame.add(gPane);

                gPane.getBarList().get(1).setFill(false);

                gPane.getBarList().get(0).start();
                gPane.getBarList().get(1).start();
                gPane.getBarList().get(2).start();

                frame.setVisible(true);

            }
        });
    }

    public class GraphPanel extends JPanel {

        private ArrayList<Bar> graphBars;
        private int nBars;

        public GraphPanel(int nBars, JFrame mainFrame) {
            this.graphBars = new ArrayList<Bar>(nBars);
            this.nBars = nBars;
            this.initBars(mainFrame.getWidth());
            for (Bar b : this.graphBars) {
                this.add(b);
            }

        }

        private void initBars(int frameW) {
            Random random = new Random();
            float hue;
            Color color;
            for (int i = 0; i < this.nBars; i++) {
                hue = random.nextFloat();
                color = Color.getHSBColor(hue, 0.9f, 1.0f);
                this.graphBars.add(new Bar(color));
            }
        }

        public ArrayList<Bar> getBarList() {
            return this.graphBars;
        }
    }

    @SuppressWarnings("serial")
    public class Bar extends JPanel {

        private Color barColor;
        private boolean fill = true;

        private float fillAmount = 0;
        private float delta = 0.01f;

        private Timer timer;
        private Rectangle bar;

        public Bar(Color barColor) {
            bar = new Rectangle();
            setBorder(new LineBorder(Color.RED));
            this.barColor = barColor;
            timer = new Timer(15, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fillAmount += isFill() ? delta : -delta;
                    //                  System.out.println(fillAmount);
                    if (fillAmount < 0) {
                        fillAmount = 0;
                        ((Timer) e.getSource()).stop();
                    } else if (fillAmount > 1.0f) {
                        fillAmount = 1f;
                        ((Timer) e.getSource()).stop();
                    }
                    repaint();
                }
            });
        }

        public void start() {
            timer.start();
        }

        public void stop() {
            timer.stop();
        }

        public void setFill(boolean fill) {
            this.fill = fill;
            if (!timer.isRunning()) {
                if (fill && fillAmount == 1) {
                    fillAmount = 0;
                } else if (!fill && fillAmount == 0) {
                    fillAmount = 1;
                }
            }
        }

        public boolean isFill() {
            return fill;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(20, 100);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(this.barColor);
            int height = Math.round(getHeight() * fillAmount);
            bar.setSize(getWidth(), height);
            bar.setLocation(0, getHeight() - height);
            g2d.fill(bar);
            g2d.dispose();
        }

    }
}