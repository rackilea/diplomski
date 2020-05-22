public static void main(String[] args) {
   try {
     double myValue = inputValidator();
     System.out.println(isNegative(myValue)); // check if number is negative
   }catch (NegativeNumberException e){
     e.printStackTrace();
   }
   catch (NonDigitNumberException e){
     e.printStackTrace();
   }
   catch(Exception e){
     e.printStackTrace();
   }
 }