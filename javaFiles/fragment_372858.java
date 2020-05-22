public class FizzBuzz {

    private final OutputStream out;

    public FizzBuzz(OutputStream out) {
      this.out = out;
    }

    public void runFizzBuzzUpTo(int n) {
      for (int i = 1; i < n; i++) {
        if ( writeIfTrue(n % 3 == 0, "Fizz") ) { 
          continue;
        }
        if ( writeIfTrue(n % 5 == 0, "Buzz") ) { 
          continue;
        }
        out.println(n);
      }
    }

    private boolean writeIfTrue(boolean toCheck, String word) {
      if (toCheck) {
        out.println(word);
      }
      return toCheck;
    }

   public static void main(String[] args) {
     new FizzBuzz(System.out).runFizzBuzzUpto(30);
   }
}