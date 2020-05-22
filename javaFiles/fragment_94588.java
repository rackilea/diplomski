import java.awt.*;
import javax.swing.*;

/**
 * @see https://stackoverflow.com/a/10097538/230513
 * @see https://stackoverflow.com/a/2846497/230513
 * @see https://stackoverflow.com/a/3518047/230513
 */
public class ScrollPanePaint extends JFrame {

    private static final int TILE = 64;

    public ScrollPanePaint() {
        JViewport viewport = new MyViewport();
        viewport.setView(new MyPanel());
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewport(viewport);
        this.add(scrollPane);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private static class MyViewport extends JViewport {

        public MyViewport() {
            this.setOpaque(false);
            this.setPreferredSize(new Dimension(6 * TILE, 6 * TILE));
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.blue);
            g.fillRect(TILE, TILE, 3 * TILE, 3 * TILE);
        }
    }

    private static class MyPanel extends JPanel {

        public MyPanel() {
            this.setOpaque(false);
            this.setPreferredSize(new Dimension(9 * TILE, 9 * TILE));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.lightGray);
            int w = this.getWidth() / TILE + 1;
            int h = this.getHeight() / TILE + 1;
            for (int row = 0; row < h; row++) {
                for (int col = 0; col < w; col++) {
                    if ((row + col) % 2 == 0) {
                        g.fillRect(col * TILE, row * TILE, TILE, TILE);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ScrollPanePaint();
            }
        });
    }
}