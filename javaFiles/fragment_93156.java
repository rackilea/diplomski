private int computeMathAbs(String input){
   int indexOfBracket = input.indexOf("(");
   int indexOfCloseBracket = input.indexOf(")");
   String value = input.subString(indexOfBracket,indexOfCloseBracket);
   int valueInt = computeFromString(value);
   int result = Math.abs(valueInt);
   return result;
}