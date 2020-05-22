class DrawPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (int i = 0; i < getHeight(); i = i + 10) {
            g.drawLine(0, i, getWidth(), i);
        }
        for (int i = 0; i < getWidth(); i = i + 10) {
            g.drawLine(i, 0, i, getHeight());
        }

        g.setColor(Color.RED);
        g.fillOval(20, 70, 10, 10);
        g.setColor(Color.GREEN);
        g.fillRect(120, 40, 10, 10);
    }
}

DrawPanel drawPanel = new DrawPanel();
drawPanel.setBackground(Color.WHITE);