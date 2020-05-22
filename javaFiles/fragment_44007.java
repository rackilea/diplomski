protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Font f = new Font("Times", Font.BOLD, 15);
    g.setFont(f);
    g.drawString(":::: text ::::", 100, 100);
    g.drawString(":::: text ::::", 100, 500);
    this.setSize(1600, 30);  // **** HERE ****
}