public enum Color {
 WHITE, BLACK, RED, YELLOW, BLUE;  //; is required here.

 @Override public String toString() {
   //only capitalize the first letter
   String s = super.toString();
   return s.substring(0, 1) + s.substring(1).toLowerCase();
 }
}

public myClass (Color color)
{}