class YourClass {

   private final List<Point> points = new ArrayList<Point>();

   public boolean addPoint (Point p) {
      boolean result = points.add(p);
      extremes();
      return result;
   }
}