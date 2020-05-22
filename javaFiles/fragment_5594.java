JPanel jPanel = new JPanel() {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(100, 50, c, c);
        g.fillOval(400, 50, c, c);
    }
};