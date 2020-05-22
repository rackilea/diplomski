public void paintComponent(Graphics g){
   super.paintComponent(g);
   int angle = getSliderValue(); //you have to implement this function

   int startX = getWidth()/2;
   int startY = getHeight()/2;
   int length = 100;

   int endX = startX + (int)Math.cos(Math.toRadians(angle)) * length;
   int endY = startY + (int)Math.sin(Math.toRadians(angle)) * length;

  g.drawLine(startX, startY, endX, endY);
}