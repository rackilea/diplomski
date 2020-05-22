boolean checkChar(String string Char[] array){
    return checkCharHelper(string, array, 0);
}

boolean checkCharHelper(String string, Char[] array, int index){
   if(index >= string.length){
      return false;
   }
   if(string.charAt(0) != array[i])
   {
      //Code here
     return true;
   }
   return checkCharHelper(string, array, index + 1);  
}