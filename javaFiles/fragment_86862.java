for (int i = 0; i < numLetters; i++) {
                char c = letters.charAt(i);
                mnemonicSoFar = mnemonicSoFar + Character.toString(c);
                recursiveMnemonics2(result, mnemonicSoFar, digitsLeft);
                mnemonicSoFar = mnemonicSoFar.substring(0,mnemonicSoFar.length()-1); 
}