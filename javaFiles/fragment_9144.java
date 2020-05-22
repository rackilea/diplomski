protected void paintComponent(Graphics g) {
   int w = getWidth();
   int h = getHeight();
   int x1 = w / 3;
   int x2 = w * 2 / 3;

   g.setColor(Color.GREEN);
   g.fillRect(0, 0, x1, h)
   g.setColor(Color.YELLOW);
   g.fillRect(x1, 0, x2 - x1, h)
   g.setColor(Color.RED);
   g.fillRect(x2, 0, w - x2, h)

   super.paintComponent();
}