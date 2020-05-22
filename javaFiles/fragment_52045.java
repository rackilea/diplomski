import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Random rnd = new Random();
                int[] binCounts = new int[10];
                for (int index = 0; index < binCounts.length; index++) {
                    binCounts[index] = rnd.nextInt(100);
                }
                JFrame frame = new JFrame();
                frame.add(new DrawingPanel(binCounts));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class DrawingPanel extends JPanel {

        private int[] binCounts;
        private int max;

        public DrawingPanel(int[] binCounts) {
            this.binCounts = binCounts;
            max = Arrays.stream(binCounts).max().getAsInt();

            System.out.println(max);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 800);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int barWidth = 800 / binCounts.length;
            for (int i = 0; i < binCounts.length; i++) {
                int barHeight = (int)((binCounts[i] / (double)max) * getHeight());
                // I personally would cache this until the state of the component
                // changes, but for brevity
                Rectangle rect = new Rectangle(i * barWidth, getHeight() - barHeight, barWidth, barHeight);
                g2d.setColor(Color.BLUE);
                g2d.fill(rect);
                g2d.setColor(Color.BLACK);
                g2d.draw(rect);
            }
            g2d.dispose();

        }
    }

}