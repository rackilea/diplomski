public void mouseExit(MouseEvent evt) {
    Point p = evt.getPoint();
    Rectangle bounds = getBounds();

    bounds.x += 4;
    bounds.y += 4;
    bounds.width -= 4;
    bounds.height -= 4;

   if ((p.x < bounds.x || p.x > bounds.x + bounds.width) && (p.y < bounds.y || p.y > bounds.y + bounds.height) {

       System.out.println("Elvis has left the building");

   }

}