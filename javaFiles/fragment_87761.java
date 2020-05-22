public boolean isInteger(String integerString){

   try{
      Integer.parseInt(integerString);
      return true;
   } catch (NumberFormatException nfe) {
      return false;
   }
}