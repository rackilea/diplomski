class Line{
   PVector p1;
   PVector p2;

   public Line(float x1, float y1, float x2, float y2){
      p1 = new PVector(x1, y1);
      p2 = new PVector(x2, y2);
   }

   public Line(PVector origin, float angle, float distance){
      p1 = origin;
      p2 = new PVector(origin.x + cos(angle)*distance, origin.y + sin(angle)*distance);
   }
}