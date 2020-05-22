public class Immutable {
     private final char[] state = "Hi Mom".getChars();

     public char[] getState() {
         return state.clone();
     }
  }