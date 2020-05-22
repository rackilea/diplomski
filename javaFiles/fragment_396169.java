public class NumberConverter {
   public static void main(String[] args) {
       int i = Integer.parseInt(args[0]);
       toBinary(i);
   }

   public static void toBinary(int int1){
       System.out.println(int1 + " in binary is");
       System.out.println(Integer.toBinaryString(int1));
   }
}