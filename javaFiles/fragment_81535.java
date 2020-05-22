JLabel label = new JLabel(icon) {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hi", 10, 10); //these are x and y positions
    }
};