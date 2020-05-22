private static void recursiveMnemonics(ArrayList<String> result, String mnemonicSoFar, String digitsLeft) {
   if(digitsLeft.length() == 0) {
       result.add(mnemonicSoFar);
       return;
   }
   String letters = digitLetters(digitsLeft.charAt(0));
   digitsLeft = digitsLeft.substring(1);
   for(int i = 0; i < letters.length(); i++) {
      mnemonicSoFar = mnemonicSoFar + letters.charAt(i);
      recursiveMnemonics(result, mnemonicSoFar, digitsLeft);
      mnemonicSoFar = mnemonicSoFar.substring(0,mnemonicSoFar.length()-1);
   }
}