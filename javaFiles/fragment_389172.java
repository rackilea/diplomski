import java.awt.*;
    import javax.swing.*;

    public class SwingMain extends JPanel {

       final static int WIDTH      = 700;
       final static int HEIGHT     = 700;
       final static int SEPARATION = 100;
       final static int DIAMETER   = 25;
       final static int NBALLS     = 4;
       final static int XSTART     = WIDTH / (NBALLS + 2);
       final static int YSTART     = HEIGHT / (NBALLS + 2);
       JFrame           frame      = new JFrame();
       int[][]          numbers    = new int[NBALLS - 1][NBALLS - 1];

       public static void main(String[] args) {
          SwingUtilities.invokeLater(() -> new SwingMain().start());
       }

       public void start() {
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setPreferredSize(new Dimension(WIDTH, HEIGHT));
          frame.add(this);
          setBackground(Color.RED);
          frame.pack();
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
          // populate numbers in 2D array.
          for (int r = 0; r < NBALLS - 1; r++) {
             for (int c = 0; c < NBALLS - 1; c++) {
                numbers[r][c] = r * (NBALLS - 1) + c + 1;
             }
          }
       }

       @Override
       public void paintComponent(Graphics g) {
          super.paintComponent(g);
          Graphics2D g2d = (Graphics2D) g;

          // Allow smoothing of the graphics.
          g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
          g2d.setColor(Color.white);

          // Iterating by the number of balls is more consistent than
          // by x and y due to round of errors.

          int y = YSTART;
          for (int r = 0; r < NBALLS; r++) {
             int x = XSTART;
             for (int c = 0; c < NBALLS; c++) {
                g2d.fillOval(x, y, DIAMETER, DIAMETER);
                x += SEPARATION;
             }
             y += SEPARATION;
          }

          // This is the same as above except that the start begins
          // halfway between the first row and column

          // have the size of the font track with the diameter of the balls
          g2d.setFont(new Font("ARIAL", Font.BOLD, DIAMETER));
          FontMetrics fm = g2d.getFontMetrics();
          y = YSTART + SEPARATION / 2;
          for (int r = 0; r < NBALLS - 1; r++) {
             int x = XSTART + SEPARATION / 2;
             for (int c = 0; c < NBALLS - 1; c++) {
                String number = Integer.toString(numbers[r][c]);

                // Do some final position adjustment with the font metrics to
                // center the number

                int strWidth = fm.stringWidth(number);
                int strHeight = fm.getAscent();
                g2d.drawString(number,
                      x - strWidth / 2 + DIAMETER / 2,
                      y + strHeight);

                x += SEPARATION;
             }
             y += SEPARATION;
          }

       }

    }