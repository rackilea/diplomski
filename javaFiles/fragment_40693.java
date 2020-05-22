panel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xPos = ...
        paintIcon(this, g, xPos, yPos);
    }
}