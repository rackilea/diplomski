public class IntArgsTest {
   public static void main(int[] args) {

      IntArgsTest iat = new IntArgsTest(args);

   }

   public IntArgsTest(int[] n) {
      System.out.println(n[0]);
   };

   public static void main(String[] args) {
      int[] intArgs = new int[args.length];

      for (int i : intArgs) {
         try {
            intArgs[i] = Integer.parseInt(args[i]);
         } catch (NumberFormatException e) {
            System.err.println("Failed trying to parse a non-numeric argument, " + args[i]);
         }
      }
      main(intArgs);
   }
}