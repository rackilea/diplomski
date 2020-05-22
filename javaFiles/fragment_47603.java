public static void main(String[] args) throws IOException {
    JFrame frame = new JFrame("Test");
    frame.add(new JComponent() {
        Point p1, p2;
        {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (p1 == null || p2 != null) { 
                        p1 = e.getPoint();
                        p2 = null;
                    } else {
                        p2 = e.getPoint();
                    } 
                    repaint();
                }
            });
            setPreferredSize(new Dimension(400, 300));
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(p1 != null && p2 != null) {
                int r = (int) Math.round(p1.distance(p2));
                g.drawOval(p1.x - r, p1.y - r, 2 * r, 2 * r);
            }
        }
    });
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}