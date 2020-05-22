static int x=10;
static int y=11;

protected void paintComponent(Graphics g){
   super.paintComponent(g);
    for (String line : description.split("\n"))
        g.drawString(line, x, y += g.getFontMetrics().getHeight());
}