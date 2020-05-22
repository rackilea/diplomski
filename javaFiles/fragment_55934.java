@Override
public void paintComponent(Graphics g) {
   super.paintComponent(g);

  Graphics2D g2d = (Graphics2D) g;

   for (Entity e : manager.getEntities()) {
       if (!e.isVisible()) {
           continue;
       }

       if (e instanceof CityLabel) {
           drawCity();
       } else if (e instanceof MilitaryBase) {
           drawMilitaryBase();
       }
   }
}