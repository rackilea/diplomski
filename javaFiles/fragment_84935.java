public void paintComponent(graphics g) {
    super.paintComponent(g);
    dLine() {
        g.drawLine(10, 10, 160, 10);
    }
    dRect() {
        g.drawRect(10, 10, 150, 50);
    }
    dOval() {
        g.drawOval(10, 10, 150, 50);
    }
    fill() {
        g.setColor(Color.GREEN);
            if (rect.isSelected()) {
                g.fillRect(10, 10, 150, 50);
            } else if (oval.isSelected()) {
                g.fillOval(10, 10, 150, 50);
            }
        }
    erase() {
        g.setColor(Color.WHITE);
        if (rect.isSelected()) {
            g.fillRect(10, 10, 150, 50);
        } else if (oval.isSelected()) {
            g.fillOval(10, 10, 150, 50);
        }
    }
}