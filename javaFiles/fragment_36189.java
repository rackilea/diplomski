public class InputReader { //not a verb, upper case

   public String var1;
   public String var2;

   // removed the default constructor, there is no need for it
   public void readInput() { //this is a method! not constructor!

      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Enter Var 1:");
      this.var1 = input.readLine();

      System.out.println("Enter Var 2:");
      this.var2 = input.readLine();

   }
}