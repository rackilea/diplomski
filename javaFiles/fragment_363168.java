Rectangle mask = new Rectangle.Float(x, y, width, height);

protected boolean wallCollision() {
     for (Line2D.Float l : level.walls) {
          if (l.intersects(this.mask)
               return true;
     }
     return false;
}