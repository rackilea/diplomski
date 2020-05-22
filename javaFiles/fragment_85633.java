public class Test4 {

    public static String a;
    public static CustomDrawingPanel content;
    public static JFrame frame = new JFrame();
    final static int OVAL_WIDTH = 10;
    final static int OVAL_HEIGHT = 10;
    static int x = -20, y = -20;
    public static MouseMotionListener listener = new ContentListener();

    public static void main(String[] args) throws InterruptedException {
        int h = 250;
        int f = 200;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        content = new CustomDrawingPanel();
        content.addMouseMotionListener(listener);
        frame.add(content);

        frame.getContentPane().setPreferredSize(new Dimension(h, f));
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    //class that performs custom drawing
    static class CustomDrawingPanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);  //Always call this
            g.drawOval(x, y, 10, 10);
        }
    }

    //listener to the mouse motion
    static class ContentListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            mouseMoved(e); //if you delete this line, when you drag your circle will hang
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            x = e.getX() - OVAL_WIDTH / 2;
            y = e.getY() - OVAL_HEIGHT / 2;
            content.repaint();
        }
    }
}