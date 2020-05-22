public class FrameTest {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Platform Game");
        f.setLocationRelativeTo(null);
        f.setUndecorated(true);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gs = ge.getDefaultScreenDevice();
        gs.setFullScreenWindow(f);

        JDesktopPane pane = new MyPanel();
        JInternalFrame frame = new JInternalFrame("Options", false, true, false, false);
        frame.setVisible(true);
        frame.setSize(100, 100);
        frame.setLocation(10, 10);
        pane.add(frame);
        f.setContentPane(pane);

        f.setVisible(true);
    }

    private static class MyPanel extends JDesktopPane {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);

            g.drawString("Free memory " + Runtime.getRuntime().freeMemory() / 1024 + " KB", 10, 12);
            g.drawString("Total memory " + Runtime.getRuntime().totalMemory() / 1024 + " KB", 10, 24);
            g.drawString("Max memory " + Runtime.getRuntime().maxMemory() / 1024 + " KB", 10, 36);
        }
    }
}