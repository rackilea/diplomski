import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private RotatedLabel timeLabel;
        private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        public TestPane() {
            setLayout(new GridBagLayout());
            timeLabel = new RotatedLabel(currentTime());
            add(timeLabel);

            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timeLabel.setText(currentTime());
                }
            });
            timer.start();
        }

        public String currentTime() {
            LocalTime lt = LocalTime.now();
            return lt.format(formatter);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class RotatedLabel extends JPanel {

        private String text;

        public RotatedLabel() {
            super();
            setOpaque(false);
            setFont(UIManager.getDefaults().getFont("label.font"));
        }

        public RotatedLabel(String text) {
            this();
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
            revalidate();
            repaint();
        }

        protected Dimension getTextBounds() {
            FontMetrics fm = getFontMetrics(getFont());
            return new Dimension(fm.stringWidth(text), fm.getHeight());
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = getTextBounds();
            return new Dimension(size.height, size.width);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
            AffineTransform aT = g2.getTransform();
            double x = getWidth() / 2.0;
            double y = getHeight() / 2.0;
            aT.rotate(Math.toRadians(90), x, y);
            g2.setTransform(aT);

            FontMetrics fm = g2.getFontMetrics();
            float xPos = (getWidth() - fm.stringWidth(getText())) / 2.0f;
            float yPos = ((getHeight() - fm.getHeight()) / 2.0f) + fm.getAscent();
            g2.drawString(text, xPos, yPos);
            g2.dispose();
        }
    }
}