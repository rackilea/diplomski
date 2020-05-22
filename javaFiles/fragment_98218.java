import java.awt.*;
import java.awt.event.*;

public class AWTPaintTest {

    public static void main(String[] args) {
        Frame frame = new Frame();
        // frame.add(new AWTGLCanvas(), BorderLayout.CENTER);
        frame.add(new MemoryPanel(), BorderLayout.SOUTH);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    private static class MemoryPanel extends Panel {

        private final Runtime r = Runtime.getRuntime();

        public MemoryPanel() {
            this.setPreferredSize(new Dimension(240, 120));
            this.setForeground(Color.blue);
            this.setFont(new Font("Monospaced", Font.BOLD, 16));
            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    r.gc();
                    MemoryPanel.this.repaint();
                }
            });
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            long m = r.maxMemory();
            long t = r.totalMemory();
            long f = r.freeMemory();
            int y = g.getFontMetrics().getHeight() + 4;
            g.drawString("Memory max:   " + toMB(m), 5, 1 * y);
            g.drawString("Memory total: " + toMB(t), 5, 2 * y);
            g.drawString("Memory free:  " + toMB(f), 5, 3 * y);
            g.drawString("Memory used:  " + toMB(t - f), 5, 4 * y);
            g.drawString("Click to update.", 5, 5 * y);
        }

        private String toMB(long bytes) {
            return (bytes / 1024) / 1024 + " MB";
        }
    }
}