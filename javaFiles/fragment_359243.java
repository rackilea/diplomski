public class Program {

   private MathFunc mult = new MathFunc() {
       public int calc(int a, int b) {
           return a*b;
       }
   };

   private MathFunc add = new MathFunc() {
       public int calc(int a, int b) {
            return a+b;
       }
   };

   private MathFunc current = null;

   // Here you choose the function
   // It doesnt matter in which way you choose the function.
   public void chooseFunc(String func) {
       if ("mult".equals(func)) 
         current = mult;
       if ("add".equals(func))
         current = add;
   }

   // here you calculate with the chosen function
   public int doCalc(int a, int b) {
       if (current != null)
          return current.calc(a, b);
       return 0;
   }

   public static void main(String[] args) {
       Program program = new Program();
       program.chooseFunc("mult");
       System.out.println(program.doCalc(3, 3)); // prints 9
       program.chooseFunc("add");
       System.out.println(program.doCalc(3, 3)); // prints 6
   }

}