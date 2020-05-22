public void draw(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    g2d.fill(new Ellipse2D.Double(center.x, center.y, itemSize, itemSize));
    g2d.setColor(Color.white);
    g2d.setFont(new Font("Arial", Font.BOLD, 14));
    g2d.drawString(itemName, (int)center.x, (int)center.y+18);
}