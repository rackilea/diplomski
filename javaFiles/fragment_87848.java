public class Main {

   private static class Shape {

      private final String value;

      private final String type;

      public Shape(String type, String value) {
         this.type = type;
         this.value = value;
      }

      @Override
      public String toString() {
         return type + "[" + value + "]";
      }
   }

   public static void main(String[] args) {
      List<Shape> balls = new ArrayList<>();
      List<Shape> triangles = new ArrayList<>();
      List<Shape> squares = new ArrayList<>();
      balls.add(new Shape("Ball", "10"));
      balls.add(new Shape("Ball", "12"));
      balls.add(new Shape("Ball", "16"));
      triangles.add(new Shape("Triangle", "1"));
      squares.add(new Shape("Square", "4"));
      squares.add(new Shape("Square", "5"));

      List<Iterator<Shape>> shapes = new ArrayList<>();
      shapes.add(balls.iterator());
      shapes.add(triangles.iterator());
      shapes.add(squares.iterator());

      List<Shape> merged = new ArrayList<>();

      boolean finished = false;
      while (!finished) {
         boolean hasNext = false;
         for (Iterator<Shape> iterator : shapes) {
            hasNext = hasNext || iterator.hasNext();
            if (iterator.hasNext()) {
               merged.add(iterator.next());
            }
         }
         finished = !hasNext;
      }

      System.out.println(merged);

   }
}