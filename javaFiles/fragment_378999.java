public boolean CollisionCheck(Rectangle rect1, Rectangle rect2) {
   rec1.move();
   rec2.move();
   if(rect1.intersects(rect2)) {
      return true;
   }
   return false;
}