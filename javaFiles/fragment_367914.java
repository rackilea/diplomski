public class Block implement Comparable<Block> {
   public int x, y;
   public Color color;
   @Override
   public int compareTo(Block other) {
      if (null==other) throw new NullPointerException();
      // implement the logic, like:
      // this will compare X, unless difference in Y is more than EG 10
      return Math.abs(y - other.y) > 10 ? y - other.y : x - other.x;
   }
   public Color getColor() { return color; }
}

public List<Block> blocks = new ArrayList<>();