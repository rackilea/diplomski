public static void main(String[] args) throws IOException {
    JFrame frame = new JFrame("Test");
    frame.add(new JComponent() {
        Point p; int r; 
        {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    p = e.getPoint(); r = 0; repaint();
                }
                public void mouseReleased(MouseEvent e) {
                    r = (int) Math.round(e.getPoint().distance(p));
                    repaint();
                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    r = (int) Math.round(e.getPoint().distance(p));
                    repaint();
                }
            });
            setPreferredSize(new Dimension(400, 300));
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(p != null) g.drawOval(p.x - r, p.y - r, 2 * r, 2 * r); 
        }
    });
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}