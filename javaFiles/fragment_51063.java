@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension size = this.getSize();
        int d = 200;
        int x = (size.width - d) / 2;
        int y = (size.height - d) / 2;
        g.fillOval(x, y, d, d);
        g.setColor(Color.blue);
        g.drawOval(x, y, d, d);
    }