public class Decimaltobinary {

public static String decimalToBinary(int valueIn){

     //    String binaryOut = "";
     //    int counter = 0;
      int remainder, i = 0;
       String binaryNum ="";
      while (valueIn != 0){
        remainder = valueIn % 2;
        valueIn /= 2;
        binaryNum = remainder+binaryNum;
      }
     return binaryNum;
}

/**
* @param args the command line arguments
*/

public static void main(String[] args) {
    // TODO code application logic here
    Scanner keyboard = new Scanner (System.in);
    System.out.println("Please enter the decimal number: ");
    int valueIn = keyboard.nextInt ();
    String outputOut = decimalToBinary(valueIn);
    System.out.println ("The output is: " +outputOut);    
   }

}