for (int index = 0; index < input.length(); index++) {
   if (Character.isWhitespace(input.charAt(index))) { 
     return index;
   }
}
return -1;