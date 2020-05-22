public void paintComponent(Graphics g) {
    super.paintComponent(g);//let component get painted normally
    System.out.println("painting");
    g.setColor(this.getBackground());
    g.fillRect(0,0,this.getWidth(),this.getHeight());
    for(Raindrop r : rain) {
        r.draw(g);
    }
}