public class Item {
   private int number1; // internal attributes
   private int number2; // are initialized
   private int number3; // in the constructor

   public Item(int number1, int number2, int number3) { // constructor
        this.number1 = number1;
        this.number2 = number2; // setup internal attributes
        this.number3 = number3;
   } 
}