public class FindFourLetterWord {

  public static void main(String[] args) {

     for (int i = 0; i < args.length; i++) {

        if (args[i].length() == 4) {
           System.out.println(args[i]);
           break;
        }
     }
  }

}