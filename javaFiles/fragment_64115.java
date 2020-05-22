public class Immutable {
     public final char[] state = "Hi Mom".getChars();

     public char[] getState() {
         return state.clone();
     }
  }