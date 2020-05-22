public class SimplePaint {
    public SimplePaint() {
        JFrame frame = new JFrame();
        frame.add(new DrawPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class DrawPanel extends JPanel {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillRect(50, 50, 150, 150);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new SimplePaint();
            }
        });
    }
}