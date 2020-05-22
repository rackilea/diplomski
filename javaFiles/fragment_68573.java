public class Item {
   private final int number1;
   private final int number2;
   private final int number3;

   public Item(int number1, int number2, int number3){
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
   }

   // add getter methods that only return internal attributes
   // values, so that it would be impossible to modify them
   // from the outside

   public int getNumber1() {
      return number1; // equivalent of return this.number1;
   }

   public int getNumber2() {
      return number2;
   }

   public int getNumber3() {
      return number3;
   }

}