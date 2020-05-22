@Override
protected void paintComponent(Graphics g) {
    g.setColor(new Color(5,5,5));
    g.fillRect(0,0,100,100);
    g.setColor(Color.Green);
    g.drawRoundRect(30,30,20,20,5,5);
    g.setColor(new Color(200,200,200));
    g.setFont(new Font("Eras Bold ITC", Font.BOLD, 150));
    g.drawString("hi",25,25);
}